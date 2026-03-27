package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.annotation.Keep;
import androidx.lifecycle.AbstractC0358o;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class HiddenLifecycleReference {
    private final AbstractC0358o lifecycle;

    public HiddenLifecycleReference(AbstractC0358o abstractC0358o) {
        this.lifecycle = abstractC0358o;
    }

    public AbstractC0358o getLifecycle() {
        return this.lifecycle;
    }
}
