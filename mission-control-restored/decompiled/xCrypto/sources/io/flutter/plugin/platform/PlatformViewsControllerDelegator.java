package io.flutter.plugin.platform;

import android.view.View;
import io.flutter.view.AccessibilityBridge;

/* JADX INFO: loaded from: classes3.dex */
public class PlatformViewsControllerDelegator implements PlatformViewsAccessibilityDelegate {
    PlatformViewsController platformViewsController;
    PlatformViewsController2 platformViewsController2;

    public PlatformViewsControllerDelegator(PlatformViewsController platformViewsController, PlatformViewsController2 platformViewsController2) {
        this.platformViewsController = platformViewsController;
        this.platformViewsController2 = platformViewsController2;
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public void attachAccessibilityBridge(AccessibilityBridge accessibilityBridge) {
        this.platformViewsController.attachAccessibilityBridge(accessibilityBridge);
        this.platformViewsController2.attachAccessibilityBridge(accessibilityBridge);
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public void detachAccessibilityBridge() {
        this.platformViewsController.detachAccessibilityBridge();
        this.platformViewsController2.detachAccessibilityBridge();
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public View getPlatformViewById(int i4) {
        return this.platformViewsController2.getPlatformViewById(i4) != null ? this.platformViewsController2.getPlatformViewById(i4) : this.platformViewsController.getPlatformViewById(i4);
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public boolean usesVirtualDisplay(int i4) {
        return this.platformViewsController2.getPlatformViewById(i4) != null ? this.platformViewsController2.usesVirtualDisplay(i4) : this.platformViewsController.usesVirtualDisplay(i4);
    }
}
