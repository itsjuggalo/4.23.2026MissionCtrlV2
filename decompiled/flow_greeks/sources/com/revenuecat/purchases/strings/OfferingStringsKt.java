package com.revenuecat.purchases.strings;

import cd.o;
import com.revenuecat.purchases.APIKeyValidator;
import com.revenuecat.purchases.Store;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0006"}, d2 = {"indefiniteArticle", "", "Lcom/revenuecat/purchases/APIKeyValidator$ValidationResult;", "configuredStore", "Lcom/revenuecat/purchases/Store;", "storeNameForLogging", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OfferingStringsKt {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Store.values().length];
            try {
                iArr[Store.PLAY_STORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Store.AMAZON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[APIKeyValidator.ValidationResult.values().length];
            try {
                iArr2[APIKeyValidator.ValidationResult.VALID.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[APIKeyValidator.ValidationResult.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[APIKeyValidator.ValidationResult.SIMULATED_STORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[APIKeyValidator.ValidationResult.OTHER_PLATFORM.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[APIKeyValidator.ValidationResult.GOOGLE_KEY_AMAZON_STORE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[APIKeyValidator.ValidationResult.AMAZON_KEY_GOOGLE_STORE.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String indefiniteArticle(APIKeyValidator.ValidationResult validationResult, Store store) {
        switch (WhenMappings.$EnumSwitchMapping$1[validationResult.ordinal()]) {
            case 1:
                int i10 = WhenMappings.$EnumSwitchMapping$0[store.ordinal()];
                return (i10 == 1 || i10 != 2) ? "a" : "an";
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return "a";
            default:
                throw new o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String storeNameForLogging(APIKeyValidator.ValidationResult validationResult, Store store) {
        switch (WhenMappings.$EnumSwitchMapping$1[validationResult.ordinal()]) {
            case 1:
                int i10 = WhenMappings.$EnumSwitchMapping$0[store.ordinal()];
                if (i10 == 1) {
                    return "Play Store";
                }
                if (i10 != 2) {
                    return null;
                }
                return "Amazon Appstore";
            case 2:
                return "Play Store";
            case 3:
                return "Test Store";
            case 4:
            case 5:
            case 6:
                return null;
            default:
                throw new o();
        }
    }
}
