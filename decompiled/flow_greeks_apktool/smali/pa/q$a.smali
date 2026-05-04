.class public final enum Lpa/q$a;
.super Ljava/lang/Enum;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lpa/q;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "a"
.end annotation


# static fields
.field public static final enum b:Lpa/q$a;

.field public static final enum c:Lpa/q$a;

.field public static final enum d:Lpa/q$a;

.field public static final enum e:Lpa/q$a;

.field public static final enum f:Lpa/q$a;

.field public static final synthetic g:[Lpa/q$a;


# instance fields
.field public final a:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 1
    new-instance v0, Lpa/q$a;

    .line 2
    .line 3
    const-string v1, "UNKNOWN"

    .line 4
    .line 5
    const/4 v2, 0x0

    .line 6
    invoke-direct {v0, v1, v2, v2}, Lpa/q$a;-><init>(Ljava/lang/String;II)V

    .line 7
    .line 8
    .line 9
    sput-object v0, Lpa/q$a;->b:Lpa/q$a;

    .line 10
    .line 11
    new-instance v0, Lpa/q$a;

    .line 12
    .line 13
    const-string v1, "CONFIG_UPDATE_STREAM_ERROR"

    .line 14
    .line 15
    const/4 v2, 0x1

    .line 16
    invoke-direct {v0, v1, v2, v2}, Lpa/q$a;-><init>(Ljava/lang/String;II)V

    .line 17
    .line 18
    .line 19
    sput-object v0, Lpa/q$a;->c:Lpa/q$a;

    .line 20
    .line 21
    new-instance v0, Lpa/q$a;

    .line 22
    .line 23
    const-string v1, "CONFIG_UPDATE_MESSAGE_INVALID"

    .line 24
    .line 25
    const/4 v2, 0x2

    .line 26
    invoke-direct {v0, v1, v2, v2}, Lpa/q$a;-><init>(Ljava/lang/String;II)V

    .line 27
    .line 28
    .line 29
    sput-object v0, Lpa/q$a;->d:Lpa/q$a;

    .line 30
    .line 31
    new-instance v0, Lpa/q$a;

    .line 32
    .line 33
    const-string v1, "CONFIG_UPDATE_NOT_FETCHED"

    .line 34
    .line 35
    const/4 v2, 0x3

    .line 36
    invoke-direct {v0, v1, v2, v2}, Lpa/q$a;-><init>(Ljava/lang/String;II)V

    .line 37
    .line 38
    .line 39
    sput-object v0, Lpa/q$a;->e:Lpa/q$a;

    .line 40
    .line 41
    new-instance v0, Lpa/q$a;

    .line 42
    .line 43
    const-string v1, "CONFIG_UPDATE_UNAVAILABLE"

    .line 44
    .line 45
    const/4 v2, 0x4

    .line 46
    invoke-direct {v0, v1, v2, v2}, Lpa/q$a;-><init>(Ljava/lang/String;II)V

    .line 47
    .line 48
    .line 49
    sput-object v0, Lpa/q$a;->f:Lpa/q$a;

    .line 50
    .line 51
    invoke-static {}, Lpa/q$a;->a()[Lpa/q$a;

    .line 52
    .line 53
    .line 54
    move-result-object v0

    .line 55
    sput-object v0, Lpa/q$a;->g:[Lpa/q$a;

    .line 56
    .line 57
    return-void
    .line 58
    .line 59
    .line 60
    .line 61
.end method

.method public constructor <init>(Ljava/lang/String;II)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 2
    .line 3
    .line 4
    iput p3, p0, Lpa/q$a;->a:I

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
.end method

.method public static synthetic a()[Lpa/q$a;
    .locals 5

    .line 1
    sget-object v0, Lpa/q$a;->b:Lpa/q$a;

    .line 2
    .line 3
    sget-object v1, Lpa/q$a;->c:Lpa/q$a;

    .line 4
    .line 5
    sget-object v2, Lpa/q$a;->d:Lpa/q$a;

    .line 6
    .line 7
    sget-object v3, Lpa/q$a;->e:Lpa/q$a;

    .line 8
    .line 9
    sget-object v4, Lpa/q$a;->f:Lpa/q$a;

    .line 10
    .line 11
    filled-new-array {v0, v1, v2, v3, v4}, [Lpa/q$a;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    return-object v0
    .line 16
.end method

.method public static valueOf(Ljava/lang/String;)Lpa/q$a;
    .locals 1

    .line 1
    const-class v0, Lpa/q$a;

    .line 2
    .line 3
    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    .line 4
    .line 5
    .line 6
    move-result-object p0

    .line 7
    check-cast p0, Lpa/q$a;

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
.end method

.method public static values()[Lpa/q$a;
    .locals 1

    .line 1
    sget-object v0, Lpa/q$a;->g:[Lpa/q$a;

    .line 2
    .line 3
    invoke-virtual {v0}, [Lpa/q$a;->clone()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, [Lpa/q$a;

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
.end method
