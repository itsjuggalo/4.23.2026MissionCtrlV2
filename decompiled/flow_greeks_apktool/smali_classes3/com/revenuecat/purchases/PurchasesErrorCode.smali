.class public final enum Lcom/revenuecat/purchases/PurchasesErrorCode;
.super Ljava/lang/Enum;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lcom/revenuecat/purchases/PurchasesErrorCode;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\"\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011j\u0002\u0008\u0012j\u0002\u0008\u0013j\u0002\u0008\u0014j\u0002\u0008\u0015j\u0002\u0008\u0016j\u0002\u0008\u0017j\u0002\u0008\u0018j\u0002\u0008\u0019j\u0002\u0008\u001aj\u0002\u0008\u001bj\u0002\u0008\u001cj\u0002\u0008\u001dj\u0002\u0008\u001ej\u0002\u0008\u001fj\u0002\u0008 j\u0002\u0008!j\u0002\u0008\"j\u0002\u0008#j\u0002\u0008$j\u0002\u0008%j\u0002\u0008&\u00a8\u0006\'"
    }
    d2 = {
        "Lcom/revenuecat/purchases/PurchasesErrorCode;",
        "",
        "code",
        "",
        "description",
        "",
        "(Ljava/lang/String;IILjava/lang/String;)V",
        "getCode",
        "()I",
        "getDescription",
        "()Ljava/lang/String;",
        "UnknownError",
        "PurchaseCancelledError",
        "StoreProblemError",
        "PurchaseNotAllowedError",
        "PurchaseInvalidError",
        "ProductNotAvailableForPurchaseError",
        "ProductAlreadyPurchasedError",
        "ReceiptAlreadyInUseError",
        "InvalidReceiptError",
        "MissingReceiptFileError",
        "NetworkError",
        "InvalidCredentialsError",
        "UnexpectedBackendResponseError",
        "InvalidAppUserIdError",
        "OperationAlreadyInProgressError",
        "UnknownBackendError",
        "InvalidAppleSubscriptionKeyError",
        "IneligibleError",
        "InsufficientPermissionsError",
        "PaymentPendingError",
        "InvalidSubscriberAttributesError",
        "LogOutWithAnonymousUserError",
        "ConfigurationError",
        "UnsupportedError",
        "EmptySubscriberAttributesError",
        "CustomerInfoError",
        "SignatureVerificationError",
        "TestStoreSimulatedPurchaseError",
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


# static fields
.field private static final synthetic $VALUES:[Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum ConfigurationError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum CustomerInfoError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum EmptySubscriberAttributesError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum IneligibleError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum InsufficientPermissionsError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum InvalidAppUserIdError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum InvalidAppleSubscriptionKeyError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum InvalidCredentialsError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum InvalidReceiptError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum InvalidSubscriberAttributesError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum LogOutWithAnonymousUserError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum MissingReceiptFileError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum NetworkError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum OperationAlreadyInProgressError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum PaymentPendingError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum ProductAlreadyPurchasedError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum ProductNotAvailableForPurchaseError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum PurchaseCancelledError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum PurchaseInvalidError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum PurchaseNotAllowedError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum ReceiptAlreadyInUseError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum SignatureVerificationError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum StoreProblemError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum TestStoreSimulatedPurchaseError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum UnexpectedBackendResponseError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum UnknownBackendError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum UnknownError:Lcom/revenuecat/purchases/PurchasesErrorCode;

.field public static final enum UnsupportedError:Lcom/revenuecat/purchases/PurchasesErrorCode;


# instance fields
.field private final code:I

.field private final description:Ljava/lang/String;


# direct methods
.method private static final synthetic $values()[Lcom/revenuecat/purchases/PurchasesErrorCode;
    .locals 29

    .line 1
    sget-object v1, Lcom/revenuecat/purchases/PurchasesErrorCode;->UnknownError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 2
    .line 3
    sget-object v2, Lcom/revenuecat/purchases/PurchasesErrorCode;->PurchaseCancelledError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 4
    .line 5
    sget-object v3, Lcom/revenuecat/purchases/PurchasesErrorCode;->StoreProblemError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 6
    .line 7
    sget-object v4, Lcom/revenuecat/purchases/PurchasesErrorCode;->PurchaseNotAllowedError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 8
    .line 9
    sget-object v5, Lcom/revenuecat/purchases/PurchasesErrorCode;->PurchaseInvalidError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 10
    .line 11
    sget-object v6, Lcom/revenuecat/purchases/PurchasesErrorCode;->ProductNotAvailableForPurchaseError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 12
    .line 13
    sget-object v7, Lcom/revenuecat/purchases/PurchasesErrorCode;->ProductAlreadyPurchasedError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 14
    .line 15
    sget-object v8, Lcom/revenuecat/purchases/PurchasesErrorCode;->ReceiptAlreadyInUseError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 16
    .line 17
    sget-object v9, Lcom/revenuecat/purchases/PurchasesErrorCode;->InvalidReceiptError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 18
    .line 19
    sget-object v10, Lcom/revenuecat/purchases/PurchasesErrorCode;->MissingReceiptFileError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 20
    .line 21
    sget-object v11, Lcom/revenuecat/purchases/PurchasesErrorCode;->NetworkError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 22
    .line 23
    sget-object v12, Lcom/revenuecat/purchases/PurchasesErrorCode;->InvalidCredentialsError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 24
    .line 25
    sget-object v13, Lcom/revenuecat/purchases/PurchasesErrorCode;->UnexpectedBackendResponseError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 26
    .line 27
    sget-object v14, Lcom/revenuecat/purchases/PurchasesErrorCode;->InvalidAppUserIdError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 28
    .line 29
    sget-object v15, Lcom/revenuecat/purchases/PurchasesErrorCode;->OperationAlreadyInProgressError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 30
    .line 31
    sget-object v16, Lcom/revenuecat/purchases/PurchasesErrorCode;->UnknownBackendError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 32
    .line 33
    sget-object v17, Lcom/revenuecat/purchases/PurchasesErrorCode;->InvalidAppleSubscriptionKeyError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 34
    .line 35
    sget-object v18, Lcom/revenuecat/purchases/PurchasesErrorCode;->IneligibleError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 36
    .line 37
    sget-object v19, Lcom/revenuecat/purchases/PurchasesErrorCode;->InsufficientPermissionsError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 38
    .line 39
    sget-object v20, Lcom/revenuecat/purchases/PurchasesErrorCode;->PaymentPendingError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 40
    .line 41
    sget-object v21, Lcom/revenuecat/purchases/PurchasesErrorCode;->InvalidSubscriberAttributesError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 42
    .line 43
    sget-object v22, Lcom/revenuecat/purchases/PurchasesErrorCode;->LogOutWithAnonymousUserError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 44
    .line 45
    sget-object v23, Lcom/revenuecat/purchases/PurchasesErrorCode;->ConfigurationError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 46
    .line 47
    sget-object v24, Lcom/revenuecat/purchases/PurchasesErrorCode;->UnsupportedError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 48
    .line 49
    sget-object v25, Lcom/revenuecat/purchases/PurchasesErrorCode;->EmptySubscriberAttributesError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 50
    .line 51
    sget-object v26, Lcom/revenuecat/purchases/PurchasesErrorCode;->CustomerInfoError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 52
    .line 53
    sget-object v27, Lcom/revenuecat/purchases/PurchasesErrorCode;->SignatureVerificationError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 54
    .line 55
    sget-object v28, Lcom/revenuecat/purchases/PurchasesErrorCode;->TestStoreSimulatedPurchaseError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 56
    .line 57
    filled-new-array/range {v1 .. v28}, [Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 58
    .line 59
    .line 60
    move-result-object v0

    .line 61
    return-object v0
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
.end method

.method static constructor <clinit>()V
    .locals 5

    .line 1
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    const-string v2, "Unknown error. Check the underlying error for more details."

    .line 5
    .line 6
    const-string v3, "UnknownError"

    .line 7
    .line 8
    invoke-direct {v0, v3, v1, v1, v2}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 9
    .line 10
    .line 11
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->UnknownError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 12
    .line 13
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 14
    .line 15
    const/4 v1, 0x1

    .line 16
    const-string v2, "Purchase was cancelled."

    .line 17
    .line 18
    const-string v3, "PurchaseCancelledError"

    .line 19
    .line 20
    invoke-direct {v0, v3, v1, v1, v2}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 21
    .line 22
    .line 23
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->PurchaseCancelledError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 24
    .line 25
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 26
    .line 27
    const/4 v1, 0x2

    .line 28
    const-string v2, "There was a problem with the store."

    .line 29
    .line 30
    const-string v3, "StoreProblemError"

    .line 31
    .line 32
    invoke-direct {v0, v3, v1, v1, v2}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 33
    .line 34
    .line 35
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->StoreProblemError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 36
    .line 37
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 38
    .line 39
    const/4 v1, 0x3

    .line 40
    const-string v2, "The device or user is not allowed to make the purchase."

    .line 41
    .line 42
    const-string v3, "PurchaseNotAllowedError"

    .line 43
    .line 44
    invoke-direct {v0, v3, v1, v1, v2}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 45
    .line 46
    .line 47
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->PurchaseNotAllowedError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 48
    .line 49
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 50
    .line 51
    const/4 v1, 0x4

    .line 52
    const-string v2, "One or more of the arguments provided are invalid."

    .line 53
    .line 54
    const-string v3, "PurchaseInvalidError"

    .line 55
    .line 56
    invoke-direct {v0, v3, v1, v1, v2}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 57
    .line 58
    .line 59
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->PurchaseInvalidError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 60
    .line 61
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 62
    .line 63
    const/4 v1, 0x5

    .line 64
    const-string v2, "The product is not available for purchase."

    .line 65
    .line 66
    const-string v3, "ProductNotAvailableForPurchaseError"

    .line 67
    .line 68
    invoke-direct {v0, v3, v1, v1, v2}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 69
    .line 70
    .line 71
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->ProductNotAvailableForPurchaseError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 72
    .line 73
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 74
    .line 75
    const/4 v1, 0x6

    .line 76
    const-string v2, "This product is already active for the user."

    .line 77
    .line 78
    const-string v3, "ProductAlreadyPurchasedError"

    .line 79
    .line 80
    invoke-direct {v0, v3, v1, v1, v2}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 81
    .line 82
    .line 83
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->ProductAlreadyPurchasedError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 84
    .line 85
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 86
    .line 87
    const/4 v1, 0x7

    .line 88
    const-string v2, "There is already another active subscriber using the same receipt."

    .line 89
    .line 90
    const-string v3, "ReceiptAlreadyInUseError"

    .line 91
    .line 92
    invoke-direct {v0, v3, v1, v1, v2}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 93
    .line 94
    .line 95
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->ReceiptAlreadyInUseError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 96
    .line 97
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 98
    .line 99
    const/16 v1, 0x8

    .line 100
    .line 101
    const-string v2, "The receipt is not valid."

    .line 102
    .line 103
    const-string v3, "InvalidReceiptError"

    .line 104
    .line 105
    invoke-direct {v0, v3, v1, v1, v2}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 106
    .line 107
    .line 108
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->InvalidReceiptError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 109
    .line 110
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 111
    .line 112
    const/16 v1, 0x9

    .line 113
    .line 114
    const-string v2, "The receipt is missing."

    .line 115
    .line 116
    const-string v3, "MissingReceiptFileError"

    .line 117
    .line 118
    invoke-direct {v0, v3, v1, v1, v2}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 119
    .line 120
    .line 121
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->MissingReceiptFileError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 122
    .line 123
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 124
    .line 125
    const/16 v1, 0xa

    .line 126
    .line 127
    const-string v2, "Error performing request."

    .line 128
    .line 129
    const-string v3, "NetworkError"

    .line 130
    .line 131
    invoke-direct {v0, v3, v1, v1, v2}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 132
    .line 133
    .line 134
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->NetworkError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 135
    .line 136
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 137
    .line 138
    const/16 v1, 0xb

    .line 139
    .line 140
    const-string v2, "There was a credentials issue. Check the underlying error for more details."

    .line 141
    .line 142
    const-string v3, "InvalidCredentialsError"

    .line 143
    .line 144
    invoke-direct {v0, v3, v1, v1, v2}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 145
    .line 146
    .line 147
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->InvalidCredentialsError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 148
    .line 149
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 150
    .line 151
    const/16 v1, 0xc

    .line 152
    .line 153
    const-string v2, "Received unexpected response from the backend."

    .line 154
    .line 155
    const-string v3, "UnexpectedBackendResponseError"

    .line 156
    .line 157
    invoke-direct {v0, v3, v1, v1, v2}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 158
    .line 159
    .line 160
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->UnexpectedBackendResponseError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 161
    .line 162
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 163
    .line 164
    const-string v1, "The app user id is not valid."

    .line 165
    .line 166
    const-string v2, "InvalidAppUserIdError"

    .line 167
    .line 168
    const/16 v3, 0xd

    .line 169
    .line 170
    const/16 v4, 0xe

    .line 171
    .line 172
    invoke-direct {v0, v2, v3, v4, v1}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 173
    .line 174
    .line 175
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->InvalidAppUserIdError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 176
    .line 177
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 178
    .line 179
    const-string v1, "The operation is already in progress."

    .line 180
    .line 181
    const-string v2, "OperationAlreadyInProgressError"

    .line 182
    .line 183
    const/16 v3, 0xf

    .line 184
    .line 185
    invoke-direct {v0, v2, v4, v3, v1}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 186
    .line 187
    .line 188
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->OperationAlreadyInProgressError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 189
    .line 190
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 191
    .line 192
    const-string v1, "There was an unknown backend error."

    .line 193
    .line 194
    const-string v2, "UnknownBackendError"

    .line 195
    .line 196
    const/16 v4, 0x10

    .line 197
    .line 198
    invoke-direct {v0, v2, v3, v4, v1}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 199
    .line 200
    .line 201
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->UnknownBackendError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 202
    .line 203
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 204
    .line 205
    const-string v1, "Apple Subscription Key is invalid or not present. In order to provide subscription offers, you must first generate a subscription key. Please see https://docs.revenuecat.com/docs/ios-subscription-offers for more info."

    .line 206
    .line 207
    const-string v2, "InvalidAppleSubscriptionKeyError"

    .line 208
    .line 209
    const/16 v3, 0x11

    .line 210
    .line 211
    invoke-direct {v0, v2, v4, v3, v1}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 212
    .line 213
    .line 214
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->InvalidAppleSubscriptionKeyError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 215
    .line 216
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 217
    .line 218
    const-string v1, "The User is ineligible for that action."

    .line 219
    .line 220
    const-string v2, "IneligibleError"

    .line 221
    .line 222
    const/16 v4, 0x12

    .line 223
    .line 224
    invoke-direct {v0, v2, v3, v4, v1}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 225
    .line 226
    .line 227
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->IneligibleError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 228
    .line 229
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 230
    .line 231
    const-string v1, "App does not have sufficient permissions to make purchases."

    .line 232
    .line 233
    const-string v2, "InsufficientPermissionsError"

    .line 234
    .line 235
    const/16 v3, 0x13

    .line 236
    .line 237
    invoke-direct {v0, v2, v4, v3, v1}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 238
    .line 239
    .line 240
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->InsufficientPermissionsError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 241
    .line 242
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 243
    .line 244
    const-string v1, "The payment is pending."

    .line 245
    .line 246
    const-string v2, "PaymentPendingError"

    .line 247
    .line 248
    const/16 v4, 0x14

    .line 249
    .line 250
    invoke-direct {v0, v2, v3, v4, v1}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 251
    .line 252
    .line 253
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->PaymentPendingError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 254
    .line 255
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 256
    .line 257
    const-string v1, "One or more of the attributes sent could not be saved."

    .line 258
    .line 259
    const-string v2, "InvalidSubscriberAttributesError"

    .line 260
    .line 261
    const/16 v3, 0x15

    .line 262
    .line 263
    invoke-direct {v0, v2, v4, v3, v1}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 264
    .line 265
    .line 266
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->InvalidSubscriberAttributesError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 267
    .line 268
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 269
    .line 270
    const-string v1, "Called logOut but the current user is anonymous."

    .line 271
    .line 272
    const-string v2, "LogOutWithAnonymousUserError"

    .line 273
    .line 274
    const/16 v4, 0x16

    .line 275
    .line 276
    invoke-direct {v0, v2, v3, v4, v1}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 277
    .line 278
    .line 279
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->LogOutWithAnonymousUserError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 280
    .line 281
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 282
    .line 283
    const/16 v1, 0x17

    .line 284
    .line 285
    const-string v2, "There is an issue with your configuration. Check the underlying error for more details."

    .line 286
    .line 287
    const-string v3, "ConfigurationError"

    .line 288
    .line 289
    invoke-direct {v0, v3, v4, v1, v2}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 290
    .line 291
    .line 292
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->ConfigurationError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 293
    .line 294
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 295
    .line 296
    const/16 v1, 0x18

    .line 297
    .line 298
    const-string v2, "There was a problem with the operation. Looks like we don\'t support that yet. Check the underlying error for more details."

    .line 299
    .line 300
    const-string v3, "UnsupportedError"

    .line 301
    .line 302
    const/16 v4, 0x17

    .line 303
    .line 304
    invoke-direct {v0, v3, v4, v1, v2}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 305
    .line 306
    .line 307
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->UnsupportedError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 308
    .line 309
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 310
    .line 311
    const/16 v1, 0x19

    .line 312
    .line 313
    const-string v2, "A request for subscriber attributes returned none."

    .line 314
    .line 315
    const-string v3, "EmptySubscriberAttributesError"

    .line 316
    .line 317
    const/16 v4, 0x18

    .line 318
    .line 319
    invoke-direct {v0, v3, v4, v1, v2}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 320
    .line 321
    .line 322
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->EmptySubscriberAttributesError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 323
    .line 324
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 325
    .line 326
    const/16 v1, 0x1c

    .line 327
    .line 328
    const-string v2, "There was a problem related to the customer info."

    .line 329
    .line 330
    const-string v3, "CustomerInfoError"

    .line 331
    .line 332
    const/16 v4, 0x19

    .line 333
    .line 334
    invoke-direct {v0, v3, v4, v1, v2}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 335
    .line 336
    .line 337
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->CustomerInfoError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 338
    .line 339
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 340
    .line 341
    const/16 v1, 0x24

    .line 342
    .line 343
    const-string v2, "Request failed signature verification. Please see https://rev.cat/trusted-entitlements for more info."

    .line 344
    .line 345
    const-string v3, "SignatureVerificationError"

    .line 346
    .line 347
    const/16 v4, 0x1a

    .line 348
    .line 349
    invoke-direct {v0, v3, v4, v1, v2}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 350
    .line 351
    .line 352
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->SignatureVerificationError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 353
    .line 354
    new-instance v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 355
    .line 356
    const/16 v1, 0x2a

    .line 357
    .line 358
    const-string v2, "Purchase failure simulated successfully in Test Store."

    .line 359
    .line 360
    const-string v3, "TestStoreSimulatedPurchaseError"

    .line 361
    .line 362
    const/16 v4, 0x1b

    .line 363
    .line 364
    invoke-direct {v0, v3, v4, v1, v2}, Lcom/revenuecat/purchases/PurchasesErrorCode;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    .line 365
    .line 366
    .line 367
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->TestStoreSimulatedPurchaseError:Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 368
    .line 369
    invoke-static {}, Lcom/revenuecat/purchases/PurchasesErrorCode;->$values()[Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 370
    .line 371
    .line 372
    move-result-object v0

    .line 373
    sput-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->$VALUES:[Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 374
    .line 375
    return-void
    .line 376
    .line 377
    .line 378
    .line 379
    .line 380
    .line 381
    .line 382
    .line 383
    .line 384
    .line 385
    .line 386
    .line 387
    .line 388
    .line 389
    .line 390
    .line 391
    .line 392
    .line 393
    .line 394
    .line 395
    .line 396
    .line 397
    .line 398
    .line 399
    .line 400
    .line 401
    .line 402
    .line 403
    .line 404
    .line 405
    .line 406
    .line 407
    .line 408
    .line 409
    .line 410
    .line 411
    .line 412
    .line 413
    .line 414
    .line 415
    .line 416
    .line 417
    .line 418
.end method

.method private constructor <init>(Ljava/lang/String;IILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .line 1
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 2
    .line 3
    .line 4
    iput p3, p0, Lcom/revenuecat/purchases/PurchasesErrorCode;->code:I

    .line 5
    .line 6
    iput-object p4, p0, Lcom/revenuecat/purchases/PurchasesErrorCode;->description:Ljava/lang/String;

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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/revenuecat/purchases/PurchasesErrorCode;
    .locals 1

    .line 1
    const-class v0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 2
    .line 3
    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    .line 4
    .line 5
    .line 6
    move-result-object p0

    .line 7
    check-cast p0, Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 8
    .line 9
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static values()[Lcom/revenuecat/purchases/PurchasesErrorCode;
    .locals 1

    .line 1
    sget-object v0, Lcom/revenuecat/purchases/PurchasesErrorCode;->$VALUES:[Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, [Lcom/revenuecat/purchases/PurchasesErrorCode;

    .line 8
    .line 9
    return-object v0
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
.method public final getCode()I
    .locals 1

    .line 1
    iget v0, p0, Lcom/revenuecat/purchases/PurchasesErrorCode;->code:I

    .line 2
    .line 3
    return v0
    .line 4
    .line 5
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

.method public final getDescription()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/revenuecat/purchases/PurchasesErrorCode;->description:Ljava/lang/String;

    .line 2
    .line 3
    return-object v0
    .line 4
    .line 5
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
