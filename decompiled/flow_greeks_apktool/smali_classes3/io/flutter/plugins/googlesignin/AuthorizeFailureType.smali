.class public final enum Lio/flutter/plugins/googlesignin/AuthorizeFailureType;
.super Ljava/lang/Enum;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/flutter/plugins/googlesignin/AuthorizeFailureType$Companion;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lio/flutter/plugins/googlesignin/AuthorizeFailureType;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000b\u0008\u0086\u0081\u0002\u0018\u0000 \r2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\u0008\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000c\u00a8\u0006\u000e"
    }
    d2 = {
        "Lio/flutter/plugins/googlesignin/AuthorizeFailureType;",
        "",
        "raw",
        "",
        "<init>",
        "(Ljava/lang/String;II)V",
        "getRaw",
        "()I",
        "UNAUTHORIZED",
        "AUTHORIZE_FAILURE",
        "PENDING_INTENT_EXCEPTION",
        "API_EXCEPTION",
        "NO_ACTIVITY",
        "Companion",
        "google_sign_in_android_release"
    }
    k = 0x1
    mv = {
        0x2,
        0x1,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field private static final synthetic $ENTRIES:Ljd/a;

.field private static final synthetic $VALUES:[Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

.field public static final enum API_EXCEPTION:Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

.field public static final enum AUTHORIZE_FAILURE:Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

.field public static final Companion:Lio/flutter/plugins/googlesignin/AuthorizeFailureType$Companion;

.field public static final enum NO_ACTIVITY:Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

.field public static final enum PENDING_INTENT_EXCEPTION:Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

.field public static final enum UNAUTHORIZED:Lio/flutter/plugins/googlesignin/AuthorizeFailureType;


# instance fields
.field private final raw:I


# direct methods
.method private static final synthetic $values()[Lio/flutter/plugins/googlesignin/AuthorizeFailureType;
    .locals 5

    .line 1
    sget-object v0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;->UNAUTHORIZED:Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 2
    .line 3
    sget-object v1, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;->AUTHORIZE_FAILURE:Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 4
    .line 5
    sget-object v2, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;->PENDING_INTENT_EXCEPTION:Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 6
    .line 7
    sget-object v3, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;->API_EXCEPTION:Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 8
    .line 9
    sget-object v4, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;->NO_ACTIVITY:Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 10
    .line 11
    filled-new-array {v0, v1, v2, v3, v4}, [Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    return-object v0
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method static constructor <clinit>()V
    .locals 3

    .line 1
    new-instance v0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 2
    .line 3
    const-string v1, "UNAUTHORIZED"

    .line 4
    .line 5
    const/4 v2, 0x0

    .line 6
    invoke-direct {v0, v1, v2, v2}, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;-><init>(Ljava/lang/String;II)V

    .line 7
    .line 8
    .line 9
    sput-object v0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;->UNAUTHORIZED:Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 10
    .line 11
    new-instance v0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 12
    .line 13
    const-string v1, "AUTHORIZE_FAILURE"

    .line 14
    .line 15
    const/4 v2, 0x1

    .line 16
    invoke-direct {v0, v1, v2, v2}, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;-><init>(Ljava/lang/String;II)V

    .line 17
    .line 18
    .line 19
    sput-object v0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;->AUTHORIZE_FAILURE:Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 20
    .line 21
    new-instance v0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 22
    .line 23
    const-string v1, "PENDING_INTENT_EXCEPTION"

    .line 24
    .line 25
    const/4 v2, 0x2

    .line 26
    invoke-direct {v0, v1, v2, v2}, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;-><init>(Ljava/lang/String;II)V

    .line 27
    .line 28
    .line 29
    sput-object v0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;->PENDING_INTENT_EXCEPTION:Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 30
    .line 31
    new-instance v0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 32
    .line 33
    const-string v1, "API_EXCEPTION"

    .line 34
    .line 35
    const/4 v2, 0x3

    .line 36
    invoke-direct {v0, v1, v2, v2}, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;-><init>(Ljava/lang/String;II)V

    .line 37
    .line 38
    .line 39
    sput-object v0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;->API_EXCEPTION:Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 40
    .line 41
    new-instance v0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 42
    .line 43
    const-string v1, "NO_ACTIVITY"

    .line 44
    .line 45
    const/4 v2, 0x4

    .line 46
    invoke-direct {v0, v1, v2, v2}, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;-><init>(Ljava/lang/String;II)V

    .line 47
    .line 48
    .line 49
    sput-object v0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;->NO_ACTIVITY:Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 50
    .line 51
    invoke-static {}, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;->$values()[Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 52
    .line 53
    .line 54
    move-result-object v0

    .line 55
    sput-object v0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;->$VALUES:[Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 56
    .line 57
    invoke-static {v0}, Ljd/b;->a([Ljava/lang/Enum;)Ljd/a;

    .line 58
    .line 59
    .line 60
    move-result-object v0

    .line 61
    sput-object v0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;->$ENTRIES:Ljd/a;

    .line 62
    .line 63
    new-instance v0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType$Companion;

    .line 64
    .line 65
    const/4 v1, 0x0

    .line 66
    invoke-direct {v0, v1}, Lio/flutter/plugins/googlesignin/AuthorizeFailureType$Companion;-><init>(Lkotlin/jvm/internal/k;)V

    .line 67
    .line 68
    .line 69
    sput-object v0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;->Companion:Lio/flutter/plugins/googlesignin/AuthorizeFailureType$Companion;

    .line 70
    .line 71
    return-void
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

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .line 1
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 2
    .line 3
    .line 4
    iput p3, p0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;->raw:I

    .line 5
    .line 6
    return-void
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
.end method

.method public static getEntries()Ljd/a;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljd/a;"
        }
    .end annotation

    .line 1
    sget-object v0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;->$ENTRIES:Ljd/a;

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

.method public static valueOf(Ljava/lang/String;)Lio/flutter/plugins/googlesignin/AuthorizeFailureType;
    .locals 1

    .line 1
    const-class v0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 2
    .line 3
    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    .line 4
    .line 5
    .line 6
    move-result-object p0

    .line 7
    check-cast p0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

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

.method public static values()[Lio/flutter/plugins/googlesignin/AuthorizeFailureType;
    .locals 1

    .line 1
    sget-object v0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;->$VALUES:[Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, [Lio/flutter/plugins/googlesignin/AuthorizeFailureType;

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
.method public final getRaw()I
    .locals 1

    .line 1
    iget v0, p0, Lio/flutter/plugins/googlesignin/AuthorizeFailureType;->raw:I

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
