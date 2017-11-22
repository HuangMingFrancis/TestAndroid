package com.example.francis.testandroid.view.progress_view;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Francis.Huang on 2017/11/16.
 * 处理进度View
 */

public class HandleAuditProgressView {

    private Context context;

    private List<AuditProgressView> auditProgressViews;

    public HandleAuditProgressView(Context context) {
        this.context = context;

        auditProgressViews = new ArrayList<>();
    }

    //创建
    public AuditProgressView createView(int stepCount, boolean isCurrentComplete, boolean isNextComplete, boolean isFirstStep, boolean isLastStep, String text) {
        AuditProgressView view = new AuditProgressView(context);
        view.setStepCount(stepCount);
        view.setIsCurrentComplete(isCurrentComplete);
        view.setIsNextComplete(isNextComplete);
        view.setIsFirstStep(isFirstStep);
        view.setIsLastStep(isLastStep);
        view.setText(text);
        view.setOnClickListener(new AuditProgressOnClick(auditProgressViews.size()));
        auditProgressViews.add(view);
        return view;
    }

    class AuditProgressOnClick implements View.OnClickListener{
        //当前节点位置
        private int currentIndex;

        public AuditProgressOnClick(int currentIndex) {
            this.currentIndex = currentIndex;
        }

        @Override
        public void onClick(View v) {
            //当前节点已完成
            if (auditProgressViews.get(currentIndex).ismIsCurrentComplete()){
                //判断前一个是否是已完成
                boolean isPrevious = true;
                if (currentIndex != 0 && !auditProgressViews.get(currentIndex - 1).ismIsCurrentComplete()){
                    isPrevious = false;
                }

                //判断后一个是否是未完成
                boolean isForward = true;
                if (currentIndex != auditProgressViews.size()-1 && auditProgressViews.get(currentIndex + 1).ismIsCurrentComplete()){
                    isForward = false;
                }
                if (isPrevious && isForward){
                    auditProgressViews.get(currentIndex).setIsCurrentComplete(false);
                    if (currentIndex != 0){
                        auditProgressViews.get(currentIndex - 1).setIsNextComplete(false);
                    }
                    auditProgressViews.get(currentIndex).invalidate();
                }
            }else{
                //判断前一个是否是未完成
                boolean isPrevious = true;
                if (currentIndex != 0 && auditProgressViews.get(currentIndex - 1).ismIsCurrentComplete()){
                    isPrevious = false;
                }

                //判断后一个是否是已完成
                boolean isForward = true;
                if (currentIndex != auditProgressViews.size()-1 && !auditProgressViews.get(currentIndex + 1).ismIsCurrentComplete()){
                    isForward = false;
                }
                if (isPrevious && isForward){
                    auditProgressViews.get(currentIndex).setIsCurrentComplete(true);
                    if (currentIndex != 0){
                        auditProgressViews.get(currentIndex - 1).setIsNextComplete(true);
                    }
                    auditProgressViews.get(currentIndex).invalidate();
                }
            }
        }
    }
}

