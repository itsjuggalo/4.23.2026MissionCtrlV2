package com.revenuecat.purchases.utils.serializers;

import bh.d;
import bh.e;
import bh.k;
import ch.f;
import dd.r;
import dd.s;
import eh.c;
import eh.h;
import eh.i;
import eh.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/utils/serializers/GoogleListSerializer;", "Lzg/b;", "", "", "<init>", "()V", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Ljava/util/List;)V", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Ljava/util/List;", "Lbh/e;", "descriptor", "Lbh/e;", "getDescriptor", "()Lbh/e;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GoogleListSerializer implements b {
    public static final GoogleListSerializer INSTANCE = new GoogleListSerializer();
    private static final e descriptor = k.b("GoogleList", d.i.f3379a);

    private GoogleListSerializer() {
    }

    @Override // zg.b, zg.k, zg.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // zg.a
    public List<String> deserialize(ch.e decoder) {
        t.f(decoder, "decoder");
        h hVar = decoder instanceof h ? (h) decoder : null;
        if (hVar == null) {
            throw new IllegalStateException("This serializer can be used only with JSON format");
        }
        i iVar = (i) j.n(hVar.i()).get("google");
        c cVarM = iVar != null ? j.m(iVar) : null;
        if (cVarM == null) {
            return r.k();
        }
        ArrayList arrayList = new ArrayList(s.u(cVarM, 10));
        Iterator<i> it = cVarM.iterator();
        while (it.hasNext()) {
            arrayList.add(j.o(it.next()).a());
        }
        return arrayList;
    }

    @Override // zg.k
    public void serialize(f encoder, List<String> value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        throw new UnsupportedOperationException("Serialization is not supported");
    }
}
