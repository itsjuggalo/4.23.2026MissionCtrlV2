package J3;

import X2.AbstractC0765l;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: J3.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0350x implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Enum[] f992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public H3.e f993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final W2.j f994c;

    /* JADX INFO: renamed from: J3.x$a */
    public static final class a extends kotlin.jvm.internal.s implements Function0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f996b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(0);
            this.f996b = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final H3.e invoke() {
            H3.e eVar = C0350x.this.f993b;
            return eVar == null ? C0350x.this.c(this.f996b) : eVar;
        }
    }

    public C0350x(String serialName, Enum[] values) {
        kotlin.jvm.internal.r.f(serialName, "serialName");
        kotlin.jvm.internal.r.f(values, "values");
        this.f992a = values;
        this.f994c = W2.k.b(new a(serialName));
    }

    public final H3.e c(String str) {
        C0349w c0349w = new C0349w(str, this.f992a.length);
        for (Enum r02 : this.f992a) {
            C0327b0.m(c0349w, r02.name(), false, 2, null);
        }
        return c0349w;
    }

    @Override // F3.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Enum deserialize(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        int iA = decoder.A(getDescriptor());
        if (iA >= 0) {
            Enum[] enumArr = this.f992a;
            if (iA < enumArr.length) {
                return enumArr[iA];
            }
        }
        throw new F3.g(iA + " is not among valid " + getDescriptor().a() + " enum values, values size is " + this.f992a.length);
    }

    @Override // F3.h
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void serialize(I3.f encoder, Enum value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        int iD = AbstractC0765l.D(this.f992a, value);
        if (iD != -1) {
            encoder.C(getDescriptor(), iD);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        sb.append(" is not a valid enum ");
        sb.append(getDescriptor().a());
        sb.append(", must be one of ");
        String string = Arrays.toString(this.f992a);
        kotlin.jvm.internal.r.e(string, "toString(this)");
        sb.append(string);
        throw new F3.g(sb.toString());
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return (H3.e) this.f994c.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().a() + '>';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0350x(String serialName, Enum[] values, H3.e descriptor) {
        this(serialName, values);
        kotlin.jvm.internal.r.f(serialName, "serialName");
        kotlin.jvm.internal.r.f(values, "values");
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        this.f993b = descriptor;
    }
}
