package f6;

import I6.AbstractC0613d0;
import I6.G;
import I6.I0;
import R5.m0;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.Q;
import p5.T;

/* JADX INFO: renamed from: f6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1760a extends G {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final I0 f17565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EnumC1762c f17566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f17567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f17568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set f17569h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AbstractC0613d0 f17570i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1760a(I0 howThisTypeIsUsed, EnumC1762c flexibility, boolean z7, boolean z8, Set set, AbstractC0613d0 abstractC0613d0) {
        super(howThisTypeIsUsed, set, abstractC0613d0);
        AbstractC2304t.f(howThisTypeIsUsed, "howThisTypeIsUsed");
        AbstractC2304t.f(flexibility, "flexibility");
        this.f17565d = howThisTypeIsUsed;
        this.f17566e = flexibility;
        this.f17567f = z7;
        this.f17568g = z8;
        this.f17569h = set;
        this.f17570i = abstractC0613d0;
    }

    public static /* synthetic */ C1760a f(C1760a c1760a, I0 i02, EnumC1762c enumC1762c, boolean z7, boolean z8, Set set, AbstractC0613d0 abstractC0613d0, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i02 = c1760a.f17565d;
        }
        if ((i8 & 2) != 0) {
            enumC1762c = c1760a.f17566e;
        }
        EnumC1762c enumC1762c2 = enumC1762c;
        if ((i8 & 4) != 0) {
            z7 = c1760a.f17567f;
        }
        boolean z9 = z7;
        if ((i8 & 8) != 0) {
            z8 = c1760a.f17568g;
        }
        boolean z10 = z8;
        if ((i8 & 16) != 0) {
            set = c1760a.f17569h;
        }
        Set set2 = set;
        if ((i8 & 32) != 0) {
            abstractC0613d0 = c1760a.f17570i;
        }
        return c1760a.e(i02, enumC1762c2, z9, z10, set2, abstractC0613d0);
    }

    @Override // I6.G
    public AbstractC0613d0 a() {
        return this.f17570i;
    }

    @Override // I6.G
    public I0 b() {
        return this.f17565d;
    }

    @Override // I6.G
    public Set c() {
        return this.f17569h;
    }

    public final C1760a e(I0 howThisTypeIsUsed, EnumC1762c flexibility, boolean z7, boolean z8, Set set, AbstractC0613d0 abstractC0613d0) {
        AbstractC2304t.f(howThisTypeIsUsed, "howThisTypeIsUsed");
        AbstractC2304t.f(flexibility, "flexibility");
        return new C1760a(howThisTypeIsUsed, flexibility, z7, z8, set, abstractC0613d0);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1760a)) {
            return false;
        }
        C1760a c1760a = (C1760a) obj;
        return AbstractC2304t.b(c1760a.a(), a()) && c1760a.b() == b() && c1760a.f17566e == this.f17566e && c1760a.f17567f == this.f17567f && c1760a.f17568g == this.f17568g;
    }

    public final EnumC1762c g() {
        return this.f17566e;
    }

    public final boolean h() {
        return this.f17568g;
    }

    @Override // I6.G
    public int hashCode() {
        AbstractC0613d0 abstractC0613d0A = a();
        int iHashCode = abstractC0613d0A != null ? abstractC0613d0A.hashCode() : 0;
        int iHashCode2 = iHashCode + (iHashCode * 31) + b().hashCode();
        int iHashCode3 = iHashCode2 + (iHashCode2 * 31) + this.f17566e.hashCode();
        int i8 = iHashCode3 + (iHashCode3 * 31) + (this.f17567f ? 1 : 0);
        return i8 + (i8 * 31) + (this.f17568g ? 1 : 0);
    }

    public final boolean i() {
        return this.f17567f;
    }

    public final C1760a j(boolean z7) {
        return f(this, null, null, z7, false, null, null, 59, null);
    }

    public C1760a k(AbstractC0613d0 abstractC0613d0) {
        return f(this, null, null, false, false, null, abstractC0613d0, 31, null);
    }

    public final C1760a l(EnumC1762c flexibility) {
        AbstractC2304t.f(flexibility, "flexibility");
        return f(this, null, flexibility, false, false, null, null, 61, null);
    }

    @Override // I6.G
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public C1760a d(m0 typeParameter) {
        AbstractC2304t.f(typeParameter, "typeParameter");
        return f(this, null, null, false, false, c() != null ? T.m(c(), typeParameter) : Q.c(typeParameter), null, 47, null);
    }

    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.f17565d + ", flexibility=" + this.f17566e + ", isRaw=" + this.f17567f + ", isForAnnotationParameter=" + this.f17568g + ", visitedTypeParameters=" + this.f17569h + ", defaultType=" + this.f17570i + ')';
    }

    public /* synthetic */ C1760a(I0 i02, EnumC1762c enumC1762c, boolean z7, boolean z8, Set set, AbstractC0613d0 abstractC0613d0, int i8, AbstractC2296k abstractC2296k) {
        this(i02, (i8 & 2) != 0 ? EnumC1762c.f17571a : enumC1762c, (i8 & 4) != 0 ? false : z7, (i8 & 8) != 0 ? false : z8, (i8 & 16) != 0 ? null : set, (i8 & 32) != 0 ? null : abstractC0613d0);
    }
}
