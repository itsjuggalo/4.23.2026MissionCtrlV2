package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {
    private final CopyOnWriteArrayList<c> cancellables = new CopyOnWriteArrayList<>();
    private Function0 enabledChangedCallback;
    private boolean isEnabled;

    public p(boolean z7) {
        this.isEnabled = z7;
    }

    public final void addCancellable(c cancellable) {
        AbstractC2304t.f(cancellable, "cancellable");
        this.cancellables.add(cancellable);
    }

    public final Function0 getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    public void handleOnBackCancelled() {
    }

    public abstract void handleOnBackPressed();

    public void handleOnBackProgressed(b backEvent) {
        AbstractC2304t.f(backEvent, "backEvent");
    }

    public void handleOnBackStarted(b backEvent) {
        AbstractC2304t.f(backEvent, "backEvent");
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
        AbstractC2304t.f(cancellable, "cancellable");
        this.cancellables.remove(cancellable);
    }

    public final void setEnabled(boolean z7) {
        this.isEnabled = z7;
        Function0 function0 = this.enabledChangedCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(Function0 function0) {
        this.enabledChangedCallback = function0;
    }
}
