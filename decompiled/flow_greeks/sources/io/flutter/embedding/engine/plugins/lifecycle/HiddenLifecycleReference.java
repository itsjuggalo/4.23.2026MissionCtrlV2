package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.annotation.Keep;
import androidx.lifecycle.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class HiddenLifecycleReference {
    private final i lifecycle;

    public HiddenLifecycleReference(i iVar) {
        this.lifecycle = iVar;
    }

    public i getLifecycle() {
        return this.lifecycle;
    }
}
