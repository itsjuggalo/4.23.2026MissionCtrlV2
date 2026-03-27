package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.annotation.Keep;
import androidx.lifecycle.AbstractC0846i;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class HiddenLifecycleReference {
    private final AbstractC0846i lifecycle;

    public HiddenLifecycleReference(AbstractC0846i abstractC0846i) {
        this.lifecycle = abstractC0846i;
    }

    public AbstractC0846i getLifecycle() {
        return this.lifecycle;
    }
}
