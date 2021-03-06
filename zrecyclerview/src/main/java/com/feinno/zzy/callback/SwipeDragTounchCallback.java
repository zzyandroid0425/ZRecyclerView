package com.feinno.zzy.callback;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class SwipeDragTounchCallback extends DragTounchCallback {

    private final SwipeTounchCallback simpleSwipeCallback;

    public SwipeDragTounchCallback(ItemDragCallback itemTouchCallback, SwipeTounchCallback.ItemSwipeCallback itemSwipeCallback, Drawable leaveBehindDrawable) {
        this(itemTouchCallback, itemSwipeCallback, leaveBehindDrawable, ItemTouchHelper.LEFT);
    }

    public SwipeDragTounchCallback(ItemDragCallback itemTouchCallback, SwipeTounchCallback.ItemSwipeCallback itemSwipeCallback, Drawable leaveBehindDrawable, int swipeDirs) {
        this(itemTouchCallback, itemSwipeCallback, leaveBehindDrawable, swipeDirs, Color.RED);
    }

    public SwipeDragTounchCallback(ItemDragCallback itemTouchCallback, SwipeTounchCallback.ItemSwipeCallback itemSwipeCallback, Drawable leaveBehindDrawable, int swipeDirs, @ColorInt int bgColor) {
        super(itemTouchCallback);
        setDefaultSwipeDirs(swipeDirs);
        simpleSwipeCallback = new SwipeTounchCallback(itemSwipeCallback, leaveBehindDrawable, swipeDirs, bgColor);
    }

    public SwipeDragTounchCallback withLeaveBehindSwipeLeft(Drawable d) {
        setDefaultSwipeDirs(getSwipeDirs(null, null)| ItemTouchHelper.LEFT);
        simpleSwipeCallback.withLeaveBehindSwipeLeft(d);
        return this;
    }

    public SwipeDragTounchCallback withLeaveBehindSwipeRight(Drawable d) {
        setDefaultSwipeDirs(getSwipeDirs(null, null) | ItemTouchHelper.RIGHT);
        simpleSwipeCallback.withLeaveBehindSwipeRight(d);
        return this;
    }

    public SwipeDragTounchCallback withHorizontalMarginDp(Context ctx, int dp) {
        simpleSwipeCallback.withHorizontalMarginDp(ctx, dp);
        return this;
    }

    public SwipeDragTounchCallback withHorizontalMarginPx(int px) {
        simpleSwipeCallback.withHorizontalMarginPx(px);
        return this;
    }

    public SwipeDragTounchCallback withBackgroundSwipeLeft(@ColorInt int bgColor) {
        simpleSwipeCallback.withBackgroundSwipeLeft(bgColor);
        return this;
    }

    public SwipeDragTounchCallback withBackgroundSwipeRight(@ColorInt int bgColor) {
        simpleSwipeCallback.withBackgroundSwipeRight(bgColor);
        return this;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        simpleSwipeCallback.onSwiped(viewHolder, direction);
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        simpleSwipeCallback.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        //Happen to know that our direct parent class doesn't (currently) draw anything...
        //super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}
