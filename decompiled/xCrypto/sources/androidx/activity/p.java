package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {
    private final CopyOnWriteArrayList<c> cancellables = new CopyOnWriteArrayList<>();
    private Function0 enabledChangedCallback;
    private boolean isEnabled;

    public p(boolean z4) {
        this.isEnabled = z4;
    }

    public final void addCancellable(c cancellable) {
        kotlin.jvm.internal.r.f(cancellable, "cancellable");
        this.cancellables.add(cancellable);
    }

    public final Function0 getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    public void handleOnBackCancelled() {
    }

    public abstract void handleOnBackPressed();

    public void handleOnBackProgressed(b backEvent) {
        kotlin.jvm.internal.r.f(backEvent, "backEvent");
    }

    public void handleOnBackStarted(b backEvent) {
        kotlin.jvm.internal.r.f(backEvent, "backEvent");
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void remove() {
        Iterator<T> it = this.cancellables.iterator();
        while (it.hasNext()) {
            ((c) it.next()).cancel();
        }
    }

    public final void removeCancellable(c cancellable) {
        kotlin.jvm.internal.r.f(cancellable, "cancellable");
        this.cancellables.remove(cancellable);
    }

    public final void setEnabled(boolean z4) {
        this.isEnabled = z4;
        Function0 function0 = this.enabledChangedCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(Function0 function0) {
        this.enabledChangedCallback = function0;
    }
}
