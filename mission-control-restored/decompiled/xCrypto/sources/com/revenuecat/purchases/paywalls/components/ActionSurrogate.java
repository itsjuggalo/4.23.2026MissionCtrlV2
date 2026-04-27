package com.revenuecat.purchases.paywalls.components;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.k0;
import W2.m;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
final class ActionSurrogate {
    public static final Companion Companion = new Companion(null);
    private final DestinationSurrogate destination;
    private final ButtonComponent.Destination.Sheet sheet;
    private final ActionTypeSurrogate type;
    private final UrlSurrogate url;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return ActionSurrogate$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DestinationSurrogate.values().length];
            try {
                iArr[DestinationSurrogate.customer_center.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DestinationSurrogate.privacy_policy.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DestinationSurrogate.terms.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DestinationSurrogate.url.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DestinationSurrogate.sheet.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DestinationSurrogate.unknown.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ActionTypeSurrogate.values().length];
            try {
                iArr2[ActionTypeSurrogate.unknown.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ActionTypeSurrogate.restore_purchases.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[ActionTypeSurrogate.navigate_back.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[ActionTypeSurrogate.navigate_to.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public /* synthetic */ ActionSurrogate(int i4, ActionTypeSurrogate actionTypeSurrogate, DestinationSurrogate destinationSurrogate, UrlSurrogate urlSurrogate, ButtonComponent.Destination.Sheet sheet, k0 k0Var) {
        if (1 != (i4 & 1)) {
            AbstractC0325a0.a(i4, 1, ActionSurrogate$$serializer.INSTANCE.getDescriptor());
        }
        this.type = actionTypeSurrogate;
        if ((i4 & 2) == 0) {
            this.destination = null;
        } else {
            this.destination = destinationSurrogate;
        }
        if ((i4 & 4) == 0) {
            this.url = null;
        } else {
            this.url = urlSurrogate;
        }
        if ((i4 & 8) == 0) {
            this.sheet = null;
        } else {
            this.sheet = sheet;
        }
    }

    public static final /* synthetic */ void write$Self(ActionSurrogate actionSurrogate, d dVar, e eVar) {
        dVar.u(eVar, 0, ActionTypeSurrogateDeserializer.INSTANCE, actionSurrogate.type);
        if (dVar.j(eVar, 1) || actionSurrogate.destination != null) {
            dVar.E(eVar, 1, DestinationSurrogateDeserializer.INSTANCE, actionSurrogate.destination);
        }
        if (dVar.j(eVar, 2) || actionSurrogate.url != null) {
            dVar.E(eVar, 2, UrlSurrogate$$serializer.INSTANCE, actionSurrogate.url);
        }
        if (!dVar.j(eVar, 3) && actionSurrogate.sheet == null) {
            return;
        }
        dVar.E(eVar, 3, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, actionSurrogate.sheet);
    }

    public final DestinationSurrogate getDestination() {
        return this.destination;
    }

    public final ButtonComponent.Destination.Sheet getSheet() {
        return this.sheet;
    }

    public final ActionTypeSurrogate getType() {
        return this.type;
    }

    public final UrlSurrogate getUrl() {
        return this.url;
    }

    public final ButtonComponent.Action toAction() {
        ButtonComponent.Destination privacyPolicy;
        int i4 = WhenMappings.$EnumSwitchMapping$1[this.type.ordinal()];
        if (i4 == 1) {
            return ButtonComponent.Action.Unknown.INSTANCE;
        }
        if (i4 == 2) {
            return ButtonComponent.Action.RestorePurchases.INSTANCE;
        }
        if (i4 == 3) {
            return ButtonComponent.Action.NavigateBack.INSTANCE;
        }
        if (i4 != 4) {
            throw new m();
        }
        DestinationSurrogate destinationSurrogate = this.destination;
        switch (destinationSurrogate == null ? -1 : WhenMappings.$EnumSwitchMapping$0[destinationSurrogate.ordinal()]) {
            case -1:
                throw new IllegalStateException("`destination` cannot be null when `action` is `navigate_to`.");
            case 0:
            default:
                throw new m();
            case 1:
                privacyPolicy = ButtonComponent.Destination.CustomerCenter.INSTANCE;
                break;
            case 2:
                if (this.url == null) {
                    throw new IllegalStateException("`url` cannot be null when `destination` is `privacy_policy`.");
                }
                privacyPolicy = new ButtonComponent.Destination.PrivacyPolicy(this.url.m165getUrl_lidz7Tp4o(), this.url.getMethod(), null);
                break;
                break;
            case 3:
                if (this.url == null) {
                    throw new IllegalStateException("`url` cannot be null when `destination` is `terms`.");
                }
                privacyPolicy = new ButtonComponent.Destination.Terms(this.url.m165getUrl_lidz7Tp4o(), this.url.getMethod(), null);
                break;
                break;
            case 4:
                if (this.url == null) {
                    throw new IllegalStateException("`url` cannot be null when `destination` is `url`.");
                }
                privacyPolicy = new ButtonComponent.Destination.Url(this.url.m165getUrl_lidz7Tp4o(), this.url.getMethod(), null);
                break;
                break;
            case 5:
                privacyPolicy = this.sheet;
                if (privacyPolicy == null) {
                    throw new IllegalStateException("`sheet` cannot be null when `destination` is `sheet`.");
                }
                break;
            case 6:
                privacyPolicy = ButtonComponent.Destination.Unknown.INSTANCE;
                break;
        }
        return new ButtonComponent.Action.NavigateTo(privacyPolicy);
    }

    public ActionSurrogate(ActionTypeSurrogate type, DestinationSurrogate destinationSurrogate, UrlSurrogate urlSurrogate, ButtonComponent.Destination.Sheet sheet) {
        r.f(type, "type");
        this.type = type;
        this.destination = destinationSurrogate;
        this.url = urlSurrogate;
        this.sheet = sheet;
    }

    public /* synthetic */ ActionSurrogate(ActionTypeSurrogate actionTypeSurrogate, DestinationSurrogate destinationSurrogate, UrlSurrogate urlSurrogate, ButtonComponent.Destination.Sheet sheet, int i4, AbstractC1585j abstractC1585j) {
        this(actionTypeSurrogate, (i4 & 2) != 0 ? null : destinationSurrogate, (i4 & 4) != 0 ? null : urlSurrogate, (i4 & 8) != 0 ? null : sheet);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0074  */
    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.jvm.internal.j] */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.revenuecat.purchases.paywalls.components.ButtonComponent$Destination$Sheet] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ActionSurrogate(com.revenuecat.purchases.paywalls.components.ButtonComponent.Action r9) {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.components.ActionSurrogate.<init>(com.revenuecat.purchases.paywalls.components.ButtonComponent$Action):void");
    }
}
