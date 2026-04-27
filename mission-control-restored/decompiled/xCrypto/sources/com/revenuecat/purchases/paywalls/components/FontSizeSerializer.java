package com.revenuecat.purchases.paywalls.components;

import F3.b;
import H3.d;
import H3.e;
import H3.h;
import I3.f;
import K3.g;
import K3.i;
import K3.w;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
final class FontSizeSerializer implements b {
    public static final FontSizeSerializer INSTANCE = new FontSizeSerializer();
    private static final e descriptor = h.a("FontSize", d.f.f739a);

    private FontSizeSerializer() {
    }

    @Override // F3.b, F3.h, F3.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public /* bridge */ /* synthetic */ void serialize(f fVar, Object obj) {
        serialize(fVar, ((Number) obj).intValue());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // F3.a
    public Integer deserialize(I3.e decoder) {
        int iK;
        r.f(decoder, "decoder");
        g gVar = decoder instanceof g ? (g) decoder : null;
        if (gVar == null) {
            throw new F3.g("Expected font_size to be part of a JSON object");
        }
        K3.h hVarK = gVar.k();
        w wVar = hVarK instanceof w ? (w) hVarK : null;
        if (wVar == null) {
            throw new F3.g("Expected font_size to be a JsonPrimitive");
        }
        if (wVar.i()) {
            String strF = wVar.f();
            switch (strF.hashCode()) {
                case -1383701233:
                    if (strF.equals("body_l")) {
                        iK = 17;
                        break;
                    }
                    throw new F3.g("Unknown font size name: " + strF);
                case -1383701232:
                    if (strF.equals("body_m")) {
                        iK = 15;
                        break;
                    }
                    throw new F3.g("Unknown font size name: " + strF);
                case -1383701226:
                    if (strF.equals("body_s")) {
                        iK = 13;
                        break;
                    }
                    throw new F3.g("Unknown font size name: " + strF);
                case -209710737:
                    if (strF.equals("heading_l")) {
                        iK = 28;
                        break;
                    }
                    throw new F3.g("Unknown font size name: " + strF);
                case -209710736:
                    if (strF.equals("heading_m")) {
                        iK = 24;
                        break;
                    }
                    throw new F3.g("Unknown font size name: " + strF);
                case -209710730:
                    if (strF.equals("heading_s")) {
                        iK = 20;
                        break;
                    }
                    throw new F3.g("Unknown font size name: " + strF);
                case 54935217:
                    if (strF.equals("body_xl")) {
                        iK = 18;
                        break;
                    }
                    throw new F3.g("Unknown font size name: " + strF);
                case 331460015:
                    if (strF.equals("heading_xxl")) {
                        iK = 40;
                        break;
                    }
                    throw new F3.g("Unknown font size name: " + strF);
                case 2088902225:
                    if (strF.equals("heading_xl")) {
                        iK = 34;
                        break;
                    }
                    throw new F3.g("Unknown font size name: " + strF);
                case 2088902232:
                    if (strF.equals("heading_xs")) {
                        iK = 16;
                        break;
                    }
                    throw new F3.g("Unknown font size name: " + strF);
                default:
                    throw new F3.g("Unknown font size name: " + strF);
            }
        }
        iK = i.k(wVar);
        return Integer.valueOf(iK);
    }

    public void serialize(f encoder, int i4) {
        r.f(encoder, "encoder");
        throw new IllegalStateException("Serialization is not implemented as it is not (yet) needed.");
    }
}
