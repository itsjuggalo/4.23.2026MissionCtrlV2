package com.revenuecat.purchases.customercenter;

import android.net.Uri;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public interface CustomerCenterManagementOption {

    public static final class Cancel implements CustomerCenterManagementOption {
        public static final Cancel INSTANCE = new Cancel();

        private Cancel() {
        }
    }

    public static final class CustomAction implements CustomerCenterManagementOption {
        private final String actionIdentifier;
        private final String purchaseIdentifier;

        public CustomAction(String actionIdentifier, String str) {
            r.f(actionIdentifier, "actionIdentifier");
            this.actionIdentifier = actionIdentifier;
            this.purchaseIdentifier = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomAction)) {
                return false;
            }
            CustomAction customAction = (CustomAction) obj;
            return r.b(this.actionIdentifier, customAction.actionIdentifier) && r.b(this.purchaseIdentifier, customAction.purchaseIdentifier);
        }

        public final String getActionIdentifier() {
            return this.actionIdentifier;
        }

        public final String getPurchaseIdentifier() {
            return this.purchaseIdentifier;
        }

        public int hashCode() {
            int iHashCode = this.actionIdentifier.hashCode() * 31;
            String str = this.purchaseIdentifier;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "CustomAction(actionIdentifier=" + this.actionIdentifier + ", purchaseIdentifier=" + this.purchaseIdentifier + ')';
        }
    }

    public static final class CustomUrl implements CustomerCenterManagementOption {
        private final Uri uri;

        public CustomUrl(Uri uri) {
            r.f(uri, "uri");
            this.uri = uri;
        }

        public static /* synthetic */ CustomUrl copy$default(CustomUrl customUrl, Uri uri, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                uri = customUrl.uri;
            }
            return customUrl.copy(uri);
        }

        public final Uri component1() {
            return this.uri;
        }

        public final CustomUrl copy(Uri uri) {
            r.f(uri, "uri");
            return new CustomUrl(uri);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CustomUrl) && r.b(this.uri, ((CustomUrl) obj).uri);
        }

        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            return this.uri.hashCode();
        }

        public String toString() {
            return "CustomUrl(uri=" + this.uri + ')';
        }
    }

    public static final class MissingPurchase implements CustomerCenterManagementOption {
        public static final MissingPurchase INSTANCE = new MissingPurchase();

        private MissingPurchase() {
        }
    }
}
