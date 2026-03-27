package j6;

import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: renamed from: j6.D, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC2230D {

    /* JADX INFO: renamed from: j6.D$a */
    public static final class a implements InterfaceC2230D {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20122a = new a();

        @Override // j6.InterfaceC2230D
        public List a(String packageFqName) {
            AbstractC2304t.f(packageFqName, "packageFqName");
            return AbstractC2595q.i();
        }
    }

    List a(String str);
}
