package com.google.protobuf;

import com.google.protobuf.y;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f7141b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile q f7142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q f7143d = new q(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f7144a = Collections.EMPTY_MAP;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f7145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7146b;

        public a(Object obj, int i10) {
            this.f7145a = obj;
            this.f7146b = i10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f7145a == aVar.f7145a && this.f7146b == aVar.f7146b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f7145a) * 65535) + this.f7146b;
        }
    }

    public q(boolean z10) {
    }

    public static q b() {
        q qVarA;
        if (!f7141b) {
            return f7143d;
        }
        q qVar = f7142c;
        if (qVar != null) {
            return qVar;
        }
        synchronized (q.class) {
            try {
                qVarA = f7142c;
                if (qVarA == null) {
                    qVarA = p.a();
                    f7142c = qVarA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return qVarA;
    }

    public y.c a(u0 u0Var, int i10) {
        android.support.v4.media.session.b.a(this.f7144a.get(new a(u0Var, i10)));
        return null;
    }
}
