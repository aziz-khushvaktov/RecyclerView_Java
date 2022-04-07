package com.example.recyclerview_14.helper;

/**
 * Two methods written on this interface like onItemMove
 * and onItemDismiss where were overrode on SimpleItemTouchHelperCallBack
 */

public interface ItemTouchHelperAdapter {
    // Drag - drop lines
    void onItemMove(int fromPosition, int toPosition);

    // Remove lines
    void onItemDismiss(int position);
}
