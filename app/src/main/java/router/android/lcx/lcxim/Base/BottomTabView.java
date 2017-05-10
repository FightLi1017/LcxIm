package router.android.lcx.lcxim.Base;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import router.android.lcx.lcxim.R;

/**
 * Created by lichenxi on 2017/5/10.
 */

public class BottomTabView extends LinearLayout {
     private int CurrentPosition=-1;

      private List<TabItem> mListTabItems;

    public BottomTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomTabView(Context context) {
        super(context);
    }

    public BottomTabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setTabListitem(List<TabItem> mListTabItems){
         setTabListitem(mListTabItems,null);
    }

    public void setTabListitem(List<TabItem> mListTabItems,View centerView){
            if (mListTabItems==null || mListTabItems.size()<2){
                 throw new RuntimeException("Item的数量请设置的多一点 小于两个ui显示效果不好");
            }

           this.mListTabItems=mListTabItems;

          for (int i=0;i<mListTabItems.size();i++){
               if (centerView!=null && mListTabItems.size()/2==i){
                   addView(centerView);
               }
              TabItem itemview=mListTabItems.get(i);
              addView(itemview);

              final int thisPosition=i;
              itemview.setOnClickListener(new OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      updatePosition(thisPosition);
                      if (onTabItemSelectListener!=null){
                          onTabItemSelectListener.onTabItemSelect(thisPosition);
                      }
                  }
              });
          }

        /**
         * 将所有的 TabItem 设置为 初始化状态
         */
        for (TabItem tab : mListTabItems) {
            tab.setstatus(TabItem.DEFAULT);
        }

        /**
         * 默认状态选择第一个
         */
        updatePosition(0);
    }


    OnTabItemSelectListener onTabItemSelectListener;

    public interface OnTabItemSelectListener{
        void onTabItemSelect(int position);
    }

    public void setOnTabItemSelectListener(OnTabItemSelectListener onTabItemSelectListener){
        this.onTabItemSelectListener = onTabItemSelectListener;
    }



    public void updatePosition(int position) {
          if (CurrentPosition!=position){
              mListTabItems.get(position).setstatus(TabItem.PRESS);

              if (CurrentPosition!=-1){
                  mListTabItems.get(CurrentPosition).setstatus(TabItem.DEFAULT);
              }
              CurrentPosition=position;
          }
    }

    public static class  TabItem  extends LinearLayout{
         public static int DEFAULT=0;
         public static  int PRESS=1;
          //标题
         private String title;
         //选中 未选中的图标
         private  int icondefault;
         private  int iconpress;
         //选中 未选中的文字颜色
         private  int textcolordefault;
         private  int textcolorpress;
         private ImageView mImageView;
         private TextView mTextView;

        public TabItem(Context context, String title,int textcolordefault, int textcolorpress,int icondefault, int iconpress) {
            super(context);
            this.textcolordefault = textcolordefault;
            this.title = title;
            this.icondefault = icondefault;
            this.iconpress = iconpress;
            this.textcolorpress = textcolorpress;
            Init();
        }

        private void Init() {
            View view= LayoutInflater.from(getContext()).inflate(R.layout.view_tab_item,this);
            mImageView=(ImageView)findViewById(R.id.ivIcon);
            mTextView=(TextView)findViewById(R.id.tvTitle);
            LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.weight = 1;
            view.setLayoutParams(layoutParams);
            mTextView.setText(title);
        }

        public void setstatus(int status){
            mTextView.setTextColor(ContextCompat.getColor(getContext(),status==PRESS?textcolorpress:textcolordefault));
            mImageView.setImageResource(status==PRESS?iconpress:icondefault);
        }


    }
}
