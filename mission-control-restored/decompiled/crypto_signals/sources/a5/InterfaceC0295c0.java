package a5;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: a5.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0295c0 extends I4.g {
    InterfaceC0310q attachChild(InterfaceC0311s interfaceC0311s);

    void cancel(CancellationException cancellationException);

    CancellationException getCancellationException();

    X4.d getChildren();

    M invokeOnCompletion(R4.l lVar);

    M invokeOnCompletion(boolean z6, boolean z7, R4.l lVar);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    Object join(I4.d dVar);

    boolean start();
}
