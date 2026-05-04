.class final Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization$CommonLocalizedString$Companion$1;
.super Lkotlin/jvm/internal/v;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization$CommonLocalizedString;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/v;",
        "Lkotlin/jvm/functions/Function0;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    k = 0x3
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field public static final INSTANCE:Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization$CommonLocalizedString$Companion$1;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1
    new-instance v0, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization$CommonLocalizedString$Companion$1;

    .line 2
    .line 3
    invoke-direct {v0}, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization$CommonLocalizedString$Companion$1;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization$CommonLocalizedString$Companion$1;->INSTANCE:Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization$CommonLocalizedString$Companion$1;

    .line 7
    .line 8
    return-void
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public constructor <init>()V
    .locals 1

    .line 1
    const/4 v0, 0x0

    .line 2
    invoke-direct {p0, v0}, Lkotlin/jvm/internal/v;-><init>(I)V

    .line 3
    .line 4
    .line 5
    return-void
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization$CommonLocalizedString$Companion$1;->invoke()Lzg/b;

    move-result-object v0

    return-object v0
.end method

.method public final invoke()Lzg/b;
    .locals 88
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lzg/b;"
        }
    .end annotation

    .line 2
    invoke-static {}, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization$CommonLocalizedString;->values()[Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization$CommonLocalizedString;

    move-result-object v0

    const-string v85, "invalid_email_error"

    const-string v86, "characters_remaining"

    const-string v1, "no_thanks"

    const-string v2, "no_subscriptions_found"

    const-string v3, "try_check_restore"

    const-string v4, "restore_purchases"

    const-string v5, "cancel"

    const-string v6, "billing_cycle"

    const-string v7, "current_price"

    const-string v8, "expired"

    const-string v9, "expires"

    const-string v10, "next_billing_date"

    const-string v11, "refund_canceled"

    const-string v12, "refund_error_generic"

    const-string v13, "refund_granted"

    const-string v14, "refund_status"

    const-string v15, "sub_earliest_expiration"

    const-string v16, "sub_earliest_renewal"

    const-string v17, "sub_expired"

    const-string v18, "contact_support"

    const-string v19, "default_body"

    const-string v20, "default_subject"

    const-string v21, "dismiss"

    const-string v22, "update_warning_title"

    const-string v23, "update_warning_description"

    const-string v24, "update_warning_update"

    const-string v25, "update_warning_ignore"

    const-string v26, "please_contact_support"

    const-string v27, "apple_subscription_manage"

    const-string v28, "google_subscription_manage"

    const-string v29, "amazon_subscription_manage"

    const-string v30, "platform_mismatch"

    const-string v31, "going_to_check_purchases"

    const-string v32, "check_past_purchases"

    const-string v33, "purchases_recovered"

    const-string v34, "purchases_recovered_explanation"

    const-string v35, "purchases_not_recovered"

    const-string v36, "purchases_not_found"

    const-string v37, "purchases_restoring"

    const-string v38, "manage_subscription"

    const-string v39, "you_have_promo"

    const-string v40, "you_have_lifetime"

    const-string v41, "web_subscription_manage"

    const-string v42, "free"

    const-string v43, "never"

    const-string v44, "free_trial_then_price"

    const-string v45, "single_payment_then_price"

    const-string v46, "discounted_recurring_then_price"

    const-string v47, "free_trial_single_payment_then_price"

    const-string v48, "free_trial_discounted_then_price"

    const-string v49, "discounted_recurring_payment_then_price"

    const-string v50, "free_trial_discounted_recurring_payment_then_price"

    const-string v51, "done"

    const-string v52, "renews_on_date_for_price"

    const-string v53, "renews_on_date"

    const-string v54, "purchase_info_expired_on_date"

    const-string v55, "purchase_info_expires_on_date"

    const-string v56, "active"

    const-string v57, "badge_cancelled"

    const-string v58, "badge_free_trial"

    const-string v59, "badge_free_trial_cancelled"

    const-string v60, "badge_lifetime"

    const-string v61, "app_store"

    const-string v62, "mac_app_store"

    const-string v63, "google_play_store"

    const-string v64, "amazon_store"

    const-string v65, "web_store"

    const-string v66, "unknown_store"

    const-string v67, "test_store"

    const-string v68, "card_store_promotional"

    const-string v69, "resubscribe"

    const-string v70, "type_subscription"

    const-string v71, "type_one_time_purchase"

    const-string v72, "buy_subscription"

    const-string v73, "last_charge_was"

    const-string v74, "next_billing_date_on"

    const-string v75, "see_all_virtual_currencies"

    const-string v76, "virtual_currency_balances_screen_header"

    const-string v77, "no_virtual_currency_balances_found"

    const-string v78, "support_ticket_create"

    const-string v79, "email"

    const-string v80, "enter_email"

    const-string v81, "description"

    const-string v82, "sent"

    const-string v83, "support_ticket_failed"

    const-string v84, "submit_ticket"

    filled-new-array/range {v1 .. v86}, [Ljava/lang/String;

    move-result-object v1

    const/16 v86, 0x0

    const/16 v87, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x0

    const/16 v20, 0x0

    const/16 v21, 0x0

    const/16 v22, 0x0

    const/16 v23, 0x0

    const/16 v24, 0x0

    const/16 v25, 0x0

    const/16 v26, 0x0

    const/16 v27, 0x0

    const/16 v28, 0x0

    const/16 v29, 0x0

    const/16 v30, 0x0

    const/16 v31, 0x0

    const/16 v32, 0x0

    const/16 v33, 0x0

    const/16 v34, 0x0

    const/16 v35, 0x0

    const/16 v36, 0x0

    const/16 v37, 0x0

    const/16 v38, 0x0

    const/16 v39, 0x0

    const/16 v40, 0x0

    const/16 v41, 0x0

    const/16 v42, 0x0

    const/16 v43, 0x0

    const/16 v44, 0x0

    const/16 v45, 0x0

    const/16 v46, 0x0

    const/16 v47, 0x0

    const/16 v48, 0x0

    const/16 v49, 0x0

    const/16 v50, 0x0

    const/16 v51, 0x0

    const/16 v52, 0x0

    const/16 v53, 0x0

    const/16 v54, 0x0

    const/16 v55, 0x0

    const/16 v56, 0x0

    const/16 v57, 0x0

    const/16 v58, 0x0

    const/16 v59, 0x0

    const/16 v60, 0x0

    const/16 v61, 0x0

    const/16 v62, 0x0

    const/16 v63, 0x0

    const/16 v64, 0x0

    const/16 v65, 0x0

    const/16 v66, 0x0

    const/16 v67, 0x0

    const/16 v68, 0x0

    const/16 v69, 0x0

    const/16 v70, 0x0

    const/16 v71, 0x0

    const/16 v72, 0x0

    const/16 v73, 0x0

    const/16 v74, 0x0

    const/16 v75, 0x0

    const/16 v76, 0x0

    const/16 v77, 0x0

    const/16 v78, 0x0

    const/16 v79, 0x0

    const/16 v80, 0x0

    const/16 v81, 0x0

    const/16 v82, 0x0

    const/16 v83, 0x0

    const/16 v84, 0x0

    const/16 v85, 0x0

    filled-new-array/range {v2 .. v87}, [[Ljava/lang/annotation/Annotation;

    move-result-object v2

    const-string v4, "com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Localization.CommonLocalizedString"

    invoke-static {v4, v0, v1, v2, v3}, Ldh/a0;->a(Ljava/lang/String;[Ljava/lang/Enum;[Ljava/lang/String;[[Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)Lzg/b;

    move-result-object v0

    return-object v0
.end method
