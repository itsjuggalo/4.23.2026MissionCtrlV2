package m3;

import java.util.Random;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: m3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1607b extends AbstractC1606a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f13541c = new a();

    /* JADX INFO: renamed from: m3.b$a */
    public static final class a extends ThreadLocal {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // m3.AbstractC1606a
    public Random g() {
        Object obj = this.f13541c.get();
        r.e(obj, "get(...)");
        return (Random) obj;
    }
}
