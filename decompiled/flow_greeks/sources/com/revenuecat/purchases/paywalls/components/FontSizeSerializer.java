package com.revenuecat.purchases.paywalls.components;

import bh.d;
import bh.e;
import bh.k;
import ch.f;
import eh.e0;
import eh.h;
import eh.i;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/FontSizeSerializer;", "Lzg/b;", "", "<init>", "()V", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;I)V", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Ljava/lang/Integer;", "Lbh/e;", "descriptor", "Lbh/e;", "getDescriptor", "()Lbh/e;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FontSizeSerializer implements b {
    public static final FontSizeSerializer INSTANCE = new FontSizeSerializer();
    private static final e descriptor = k.b("FontSize", d.f.f3376a);

    private FontSizeSerializer() {
    }

    @Override // zg.b, zg.k, zg.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public /* bridge */ /* synthetic */ void serialize(f fVar, Object obj) {
        serialize(fVar, ((Number) obj).intValue());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // zg.a
    public Integer deserialize(ch.e decoder) {
        int iK;
        t.f(decoder, "decoder");
        h hVar = decoder instanceof h ? (h) decoder : null;
        if (hVar == null) {
            throw new j("Expected font_size to be part of a JSON object");
        }
        i iVarI = hVar.i();
        e0 e0Var = iVarI instanceof e0 ? (e0) iVarI : null;
        if (e0Var == null) {
            throw new j("Expected font_size to be a JsonPrimitive");
        }
        if (e0Var.c()) {
            String strA = e0Var.a();
            switch (strA.hashCode()) {
                case -1383701233:
                    if (strA.equals("body_l")) {
                        iK = 17;
                        break;
                    }
                    throw new j("Unknown font size name: " + strA);
                case -1383701232:
                    if (strA.equals("body_m")) {
                        iK = 15;
                        break;
                    }
                    throw new j("Unknown font size name: " + strA);
                case -1383701226:
                    if (strA.equals("body_s")) {
                        iK = 13;
                        break;
                    }
                    throw new j("Unknown font size name: " + strA);
                case -209710737:
                    if (strA.equals("heading_l")) {
                        iK = 28;
                        break;
                    }
                    throw new j("Unknown font size name: " + strA);
                case -209710736:
                    if (strA.equals("heading_m")) {
                        iK = 24;
                        break;
                    }
                    throw new j("Unknown font size name: " + strA);
                case -209710730:
                    if (strA.equals("heading_s")) {
                        iK = 20;
                        break;
                    }
                    throw new j("Unknown font size name: " + strA);
                case 54935217:
                    if (strA.equals("body_xl")) {
                        iK = 18;
                        break;
                    }
                    throw new j("Unknown font size name: " + strA);
                case 331460015:
                    if (strA.equals("heading_xxl")) {
                        iK = 40;
                        break;
                    }
                    throw new j("Unknown font size name: " + strA);
                case 2088902225:
                    if (strA.equals("heading_xl")) {
                        iK = 34;
                        break;
                    }
                    throw new j("Unknown font size name: " + strA);
                case 2088902232:
                    if (strA.equals("heading_xs")) {
                        iK = 16;
                        break;
                    }
                    throw new j("Unknown font size name: " + strA);
                default:
                    throw new j("Unknown font size name: " + strA);
            }
        }
        iK = eh.j.k(e0Var);
        return Integer.valueOf(iK);
    }

    public void serialize(f encoder, int value) {
        t.f(encoder, "encoder");
        throw new IllegalStateException("Serialization is not implemented as it is not (yet) needed.");
    }
}
