package aa;

import android.app.Application;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f564b;

    public q2(Application application, String str) {
        this.f563a = application;
        this.f564b = str;
    }

    public static /* synthetic */ Object a(q2 q2Var, com.google.protobuf.a aVar) {
        synchronized (q2Var) {
            FileOutputStream fileOutputStreamOpenFileOutput = q2Var.f563a.openFileOutput(q2Var.f564b, 0);
            try {
                fileOutputStreamOpenFileOutput.write(aVar.i());
                fileOutputStreamOpenFileOutput.close();
            } finally {
            }
        }
        return aVar;
    }

    public static /* synthetic */ com.google.protobuf.a b(q2 q2Var, com.google.protobuf.e1 e1Var) {
        synchronized (q2Var) {
            try {
                FileInputStream fileInputStreamOpenFileInput = q2Var.f563a.openFileInput(q2Var.f564b);
                try {
                    com.google.protobuf.a aVar = (com.google.protobuf.a) e1Var.a(fileInputStreamOpenFileInput);
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                    return aVar;
                } catch (Throwable th) {
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (com.google.protobuf.d0 | FileNotFoundException e10) {
                h2.c("Recoverable exception while reading cache: " + e10.getMessage());
                return null;
            }
        }
    }

    public cc.j c(final com.google.protobuf.e1 e1Var) {
        return cc.j.l(new Callable() { // from class: aa.o2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return q2.b(this.f540a, e1Var);
            }
        });
    }

    public cc.b d(final com.google.protobuf.a aVar) {
        return cc.b.h(new Callable() { // from class: aa.p2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return q2.a(this.f551a, aVar);
            }
        });
    }
}
