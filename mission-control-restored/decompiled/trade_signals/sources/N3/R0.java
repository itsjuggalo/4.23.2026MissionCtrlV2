package N3;

import android.app.Application;
import com.google.protobuf.AbstractC1462a;
import com.google.protobuf.C1482v;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class R0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f5626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5627b;

    public R0(Application application, String str) {
        this.f5626a = application;
        this.f5627b = str;
    }

    public final /* synthetic */ AbstractC1462a c(com.google.protobuf.S s8) {
        synchronized (this) {
            try {
                FileInputStream fileInputStreamOpenFileInput = this.f5626a.openFileInput(this.f5627b);
                try {
                    AbstractC1462a abstractC1462a = (AbstractC1462a) s8.a(fileInputStreamOpenFileInput);
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                    return abstractC1462a;
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
            } catch (C1482v | FileNotFoundException e8) {
                I0.c("Recoverable exception while reading cache: " + e8.getMessage());
                return null;
            }
        }
    }

    public final /* synthetic */ Object d(AbstractC1462a abstractC1462a) {
        synchronized (this) {
            FileOutputStream fileOutputStreamOpenFileOutput = this.f5626a.openFileOutput(this.f5627b, 0);
            try {
                fileOutputStreamOpenFileOutput.write(abstractC1462a.i());
                fileOutputStreamOpenFileOutput.close();
            } finally {
            }
        }
        return abstractC1462a;
    }

    public P4.j e(final com.google.protobuf.S s8) {
        return P4.j.l(new Callable() { // from class: N3.P0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f5620a.c(s8);
            }
        });
    }

    public P4.b f(final AbstractC1462a abstractC1462a) {
        return P4.b.k(new Callable() { // from class: N3.Q0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f5624a.d(abstractC1462a);
            }
        });
    }
}
