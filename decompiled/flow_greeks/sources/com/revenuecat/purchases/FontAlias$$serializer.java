package com.revenuecat.purchases;

import dh.e0;
import dh.f0;
import dh.w1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002HÖ\u0001ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"com/revenuecat/purchases/FontAlias.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/FontAlias;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize-zxJdh0Q", "(Lch/e;)Ljava/lang/String;", "deserialize", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize-pDyximM", "(Lch/f;Ljava/lang/String;)V", "serialize", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FontAlias$$serializer implements e0 {
    public static final FontAlias$$serializer INSTANCE;
    private static final /* synthetic */ f0 descriptor;

    static {
        FontAlias$$serializer fontAlias$$serializer = new FontAlias$$serializer();
        INSTANCE = fontAlias$$serializer;
        f0 f0Var = new f0("com.revenuecat.purchases.FontAlias", fontAlias$$serializer);
        f0Var.g("value", false);
        descriptor = f0Var;
    }

    private FontAlias$$serializer() {
    }

    @Override // dh.e0
    public zg.b[] childSerializers() {
        return new zg.b[]{w1.f8244a};
    }

    @Override // zg.a
    public /* bridge */ /* synthetic */ Object deserialize(ch.e eVar) {
        return FontAlias.m38boximpl(m45deserializezxJdh0Q(eVar));
    }

    /* JADX INFO: renamed from: deserialize-zxJdh0Q, reason: not valid java name */
    public String m45deserializezxJdh0Q(ch.e decoder) {
        t.f(decoder, "decoder");
        return FontAlias.m39constructorimpl(decoder.A(getDescriptor()).m());
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public /* bridge */ /* synthetic */ void serialize(ch.f fVar, Object obj) {
        m46serializepDyximM(fVar, ((FontAlias) obj).m44unboximpl());
    }

    /* JADX INFO: renamed from: serialize-pDyximM, reason: not valid java name */
    public void m46serializepDyximM(ch.f encoder, String value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        ch.f fVarV = encoder.v(getDescriptor());
        if (fVarV == null) {
            return;
        }
        fVarV.F(value);
    }

    @Override // dh.e0
    public zg.b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
