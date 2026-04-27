package com.revenuecat.purchases.interfaces;

import E5.m;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.PurchasesError;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public interface RedeemWebPurchaseListener {

    public static abstract class Result {

        public static final class Error extends Result {
            private final PurchasesError error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(PurchasesError error) {
                super(null);
                r.f(error, "error");
                this.error = error;
            }

            public static /* synthetic */ Error copy$default(Error error, PurchasesError purchasesError, int i7, Object obj) {
                if ((i7 & 1) != 0) {
                    purchasesError = error.error;
                }
                return error.copy(purchasesError);
            }

            public final PurchasesError component1() {
                return this.error;
            }

            public final Error copy(PurchasesError error) {
                r.f(error, "error");
                return new Error(error);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Error) && r.b(this.error, ((Error) obj).error);
            }

            public final PurchasesError getError() {
                return this.error;
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "Error(error=" + this.error + ')';
            }
        }

        public static final class Expired extends Result {
            private final String obfuscatedEmail;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Expired(String obfuscatedEmail) {
                super(null);
                r.f(obfuscatedEmail, "obfuscatedEmail");
                this.obfuscatedEmail = obfuscatedEmail;
            }

            public static /* synthetic */ Expired copy$default(Expired expired, String str, int i7, Object obj) {
                if ((i7 & 1) != 0) {
                    str = expired.obfuscatedEmail;
                }
                return expired.copy(str);
            }

            public final String component1() {
                return this.obfuscatedEmail;
            }

            public final Expired copy(String obfuscatedEmail) {
                r.f(obfuscatedEmail, "obfuscatedEmail");
                return new Expired(obfuscatedEmail);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Expired) && r.b(this.obfuscatedEmail, ((Expired) obj).obfuscatedEmail);
            }

            public final String getObfuscatedEmail() {
                return this.obfuscatedEmail;
            }

            public int hashCode() {
                return this.obfuscatedEmail.hashCode();
            }

            public String toString() {
                return "Expired(obfuscatedEmail=" + this.obfuscatedEmail + ')';
            }
        }

        public static final class InvalidToken extends Result {
            public static final InvalidToken INSTANCE = new InvalidToken();

            private InvalidToken() {
                super(null);
            }
        }

        public static final class PurchaseBelongsToOtherUser extends Result {
            public static final PurchaseBelongsToOtherUser INSTANCE = new PurchaseBelongsToOtherUser();

            private PurchaseBelongsToOtherUser() {
                super(null);
            }
        }

        public static final class Success extends Result {
            private final CustomerInfo customerInfo;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(CustomerInfo customerInfo) {
                super(null);
                r.f(customerInfo, "customerInfo");
                this.customerInfo = customerInfo;
            }

            public static /* synthetic */ Success copy$default(Success success, CustomerInfo customerInfo, int i7, Object obj) {
                if ((i7 & 1) != 0) {
                    customerInfo = success.customerInfo;
                }
                return success.copy(customerInfo);
            }

            public final CustomerInfo component1() {
                return this.customerInfo;
            }

            public final Success copy(CustomerInfo customerInfo) {
                r.f(customerInfo, "customerInfo");
                return new Success(customerInfo);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Success) && r.b(this.customerInfo, ((Success) obj).customerInfo);
            }

            public final CustomerInfo getCustomerInfo() {
                return this.customerInfo;
            }

            public int hashCode() {
                return this.customerInfo.hashCode();
            }

            public String toString() {
                return "Success(customerInfo=" + this.customerInfo + ')';
            }
        }

        public /* synthetic */ Result(AbstractC2148j abstractC2148j) {
            this();
        }

        public final boolean isSuccess() {
            if (this instanceof Success) {
                return true;
            }
            if ((this instanceof Error) || r.b(this, InvalidToken.INSTANCE) || (this instanceof Expired) || r.b(this, PurchaseBelongsToOtherUser.INSTANCE)) {
                return false;
            }
            throw new m();
        }

        private Result() {
        }
    }

    void handleResult(Result result);
}
