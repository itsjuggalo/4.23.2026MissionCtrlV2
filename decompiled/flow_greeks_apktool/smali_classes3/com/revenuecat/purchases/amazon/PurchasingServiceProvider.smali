.class public interface abstract Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008`\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\u0008\u0007\u0010\u0008J\u001d\u0010\r\u001a\u00020\u000c2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\n0\tH&\u00a2\u0006\u0004\u0008\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000cH&\u00a2\u0006\u0004\u0008\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000c2\u0006\u0010\u0011\u001a\u00020\nH&\u00a2\u0006\u0004\u0008\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u000c2\u0006\u0010\u0015\u001a\u00020\u0014H&\u00a2\u0006\u0004\u0008\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H&\u00a2\u0006\u0004\u0008\u001b\u0010\u001c\u00a8\u0006\u001d\u00c0\u0006\u0003"
    }
    d2 = {
        "Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;",
        "Landroid/os/Parcelable;",
        "Landroid/content/Context;",
        "context",
        "Lcom/amazon/device/iap/PurchasingListener;",
        "listener",
        "Lcd/h0;",
        "registerListener",
        "(Landroid/content/Context;Lcom/amazon/device/iap/PurchasingListener;)V",
        "",
        "",
        "skus",
        "Lcom/amazon/device/iap/model/RequestId;",
        "getProductData",
        "(Ljava/util/Set;)Lcom/amazon/device/iap/model/RequestId;",
        "getUserData",
        "()Lcom/amazon/device/iap/model/RequestId;",
        "sku",
        "purchase",
        "(Ljava/lang/String;)Lcom/amazon/device/iap/model/RequestId;",
        "",
        "reset",
        "getPurchaseUpdates",
        "(Z)Lcom/amazon/device/iap/model/RequestId;",
        "receiptId",
        "Lcom/amazon/device/iap/model/FulfillmentResult;",
        "fulfillmentResult",
        "notifyFulfillment",
        "(Ljava/lang/String;Lcom/amazon/device/iap/model/FulfillmentResult;)V",
        "purchases_defaultsBc8Release"
    }
    k = 0x1
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation


# virtual methods
.method public abstract getProductData(Ljava/util/Set;)Lcom/amazon/device/iap/model/RequestId;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/amazon/device/iap/model/RequestId;"
        }
    .end annotation
.end method

.method public abstract getPurchaseUpdates(Z)Lcom/amazon/device/iap/model/RequestId;
.end method

.method public abstract getUserData()Lcom/amazon/device/iap/model/RequestId;
.end method

.method public abstract notifyFulfillment(Ljava/lang/String;Lcom/amazon/device/iap/model/FulfillmentResult;)V
.end method

.method public abstract purchase(Ljava/lang/String;)Lcom/amazon/device/iap/model/RequestId;
.end method

.method public abstract registerListener(Landroid/content/Context;Lcom/amazon/device/iap/PurchasingListener;)V
.end method
