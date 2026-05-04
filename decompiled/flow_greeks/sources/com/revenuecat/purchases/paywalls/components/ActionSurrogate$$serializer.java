package com.revenuecat.purchases.paywalls.components;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import dh.e0;
import dh.j1;
import dh.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/ActionSurrogate.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/ActionSurrogate;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/ActionSurrogate;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/ActionSurrogate;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActionSurrogate$$serializer implements e0 {
    public static final ActionSurrogate$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        ActionSurrogate$$serializer actionSurrogate$$serializer = new ActionSurrogate$$serializer();
        INSTANCE = actionSurrogate$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.ActionSurrogate", actionSurrogate$$serializer, 4);
        j1Var.g("type", false);
        j1Var.g(FirebaseAnalytics.Param.DESTINATION, true);
        j1Var.g("url", true);
        j1Var.g("sheet", true);
        descriptor = j1Var;
    }

    private ActionSurrogate$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        return new b[]{ActionTypeSurrogateDeserializer.INSTANCE, a.p(DestinationSurrogateDeserializer.INSTANCE), a.p(UrlSurrogate$$serializer.INSTANCE), a.p(ButtonComponent$Destination$Sheet$$serializer.INSTANCE)};
    }

    @Override // zg.a
    public ActionSurrogate deserialize(e decoder) {
        int i10;
        ActionTypeSurrogate actionTypeSurrogate;
        DestinationSurrogate destinationSurrogate;
        UrlSurrogate urlSurrogate;
        ButtonComponent.Destination.Sheet sheet;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        ActionTypeSurrogate actionTypeSurrogate2 = null;
        if (cVarB.z()) {
            ActionTypeSurrogate actionTypeSurrogate3 = (ActionTypeSurrogate) cVarB.h(descriptor2, 0, ActionTypeSurrogateDeserializer.INSTANCE, null);
            DestinationSurrogate destinationSurrogate2 = (DestinationSurrogate) cVarB.n(descriptor2, 1, DestinationSurrogateDeserializer.INSTANCE, null);
            UrlSurrogate urlSurrogate2 = (UrlSurrogate) cVarB.n(descriptor2, 2, UrlSurrogate$$serializer.INSTANCE, null);
            actionTypeSurrogate = actionTypeSurrogate3;
            sheet = (ButtonComponent.Destination.Sheet) cVarB.n(descriptor2, 3, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, null);
            urlSurrogate = urlSurrogate2;
            destinationSurrogate = destinationSurrogate2;
            i10 = 15;
        } else {
            boolean z10 = true;
            int i11 = 0;
            DestinationSurrogate destinationSurrogate3 = null;
            UrlSurrogate urlSurrogate3 = null;
            ButtonComponent.Destination.Sheet sheet2 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    actionTypeSurrogate2 = (ActionTypeSurrogate) cVarB.h(descriptor2, 0, ActionTypeSurrogateDeserializer.INSTANCE, actionTypeSurrogate2);
                    i11 |= 1;
                } else if (iW == 1) {
                    destinationSurrogate3 = (DestinationSurrogate) cVarB.n(descriptor2, 1, DestinationSurrogateDeserializer.INSTANCE, destinationSurrogate3);
                    i11 |= 2;
                } else if (iW == 2) {
                    urlSurrogate3 = (UrlSurrogate) cVarB.n(descriptor2, 2, UrlSurrogate$$serializer.INSTANCE, urlSurrogate3);
                    i11 |= 4;
                } else {
                    if (iW != 3) {
                        throw new m(iW);
                    }
                    sheet2 = (ButtonComponent.Destination.Sheet) cVarB.n(descriptor2, 3, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, sheet2);
                    i11 |= 8;
                }
            }
            i10 = i11;
            actionTypeSurrogate = actionTypeSurrogate2;
            destinationSurrogate = destinationSurrogate3;
            urlSurrogate = urlSurrogate3;
            sheet = sheet2;
        }
        cVarB.c(descriptor2);
        return new ActionSurrogate(i10, actionTypeSurrogate, destinationSurrogate, urlSurrogate, sheet, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, ActionSurrogate value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        ActionSurrogate.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
