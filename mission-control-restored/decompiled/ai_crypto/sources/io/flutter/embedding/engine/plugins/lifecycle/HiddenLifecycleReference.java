package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.annotation.Keep;
import androidx.lifecycle.AbstractC0963i;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class HiddenLifecycleReference {
    private final AbstractC0963i lifecycle;

    public HiddenLifecycleReference(AbstractC0963i abstractC0963i) {
        this.lifecycle = abstractC0963i;
    }

    public AbstractC0963i getLifecycle() {
        return this.lifecycle;
    }
}
