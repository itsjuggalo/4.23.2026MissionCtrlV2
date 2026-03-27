package com.revenuecat.purchases.customercenter;

import android.net.Uri;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public interface CustomerCenterManagementOption {

    public static final class Cancel implements CustomerCenterManagementOption {
        public static final Cancel INSTANCE = new Cancel();

        private Cancel() {
        }
    }

    public static final class CustomUrl implements CustomerCenterManagementOption {
        private final Uri uri;

        public CustomUrl(Uri uri) {
            r.f(uri, "uri");
            this.uri = uri;
        }

        public static /* synthetic */ CustomUrl copy$default(CustomUrl customUrl, Uri uri, int i7, Object obj) {
            if ((i7 & 1) != 0) {
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
