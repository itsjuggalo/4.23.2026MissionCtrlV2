package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.annotation.Keep;
import androidx.lifecycle.AbstractC1157i;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class HiddenLifecycleReference {
    private final AbstractC1157i lifecycle;

    public HiddenLifecycleReference(AbstractC1157i abstractC1157i) {
        this.lifecycle = abstractC1157i;
    }

    public AbstractC1157i getLifecycle() {
        return this.lifecycle;
    }
}
