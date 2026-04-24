package a1;

import a1.n;
import android.net.Uri;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class y implements n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f9909b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f9910a;

    public static class a implements o {
        @Override // a1.o
        public n d(r rVar) {
            return new y(rVar.d(C1048h.class, InputStream.class));
        }
    }

    public y(n nVar) {
        this.f9910a = nVar;
    }

    @Override // a1.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a a(Uri uri, int i8, int i9, U0.h hVar) {
        return this.f9910a.a(new C1048h(uri.toString()), i8, i9, hVar);
    }

    @Override // a1.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri) {
        return f9909b.contains(uri.getScheme());
    }
}
