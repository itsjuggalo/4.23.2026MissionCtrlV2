.class public final enum Lde/c;
.super Ljava/lang/Enum;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lde/c$a;
    }
.end annotation


# static fields
.field public static final a:Lde/c$a;

.field public static final enum b:Lde/c;

.field public static final enum c:Lde/c;

.field public static final enum d:Lde/c;

.field public static final enum e:Lde/c;

.field public static final enum f:Lde/c;

.field public static final synthetic g:[Lde/c;

.field public static final synthetic h:Ljd/a;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 1
    new-instance v0, Lde/c;

    .line 2
    .line 3
    const-string v1, "Function"

    .line 4
    .line 5
    const/4 v2, 0x0

    .line 6
    invoke-direct {v0, v1, v2}, Lde/c;-><init>(Ljava/lang/String;I)V

    .line 7
    .line 8
    .line 9
    sput-object v0, Lde/c;->b:Lde/c;

    .line 10
    .line 11
    new-instance v0, Lde/c;

    .line 12
    .line 13
    const-string v1, "SuspendFunction"

    .line 14
    .line 15
    const/4 v2, 0x1

    .line 16
    invoke-direct {v0, v1, v2}, Lde/c;-><init>(Ljava/lang/String;I)V

    .line 17
    .line 18
    .line 19
    sput-object v0, Lde/c;->c:Lde/c;

    .line 20
    .line 21
    new-instance v0, Lde/c;

    .line 22
    .line 23
    const-string v1, "KFunction"

    .line 24
    .line 25
    const/4 v2, 0x2

    .line 26
    invoke-direct {v0, v1, v2}, Lde/c;-><init>(Ljava/lang/String;I)V

    .line 27
    .line 28
    .line 29
    sput-object v0, Lde/c;->d:Lde/c;

    .line 30
    .line 31
    new-instance v0, Lde/c;

    .line 32
    .line 33
    const-string v1, "KSuspendFunction"

    .line 34
    .line 35
    const/4 v2, 0x3

    .line 36
    invoke-direct {v0, v1, v2}, Lde/c;-><init>(Ljava/lang/String;I)V

    .line 37
    .line 38
    .line 39
    sput-object v0, Lde/c;->e:Lde/c;

    .line 40
    .line 41
    new-instance v0, Lde/c;

    .line 42
    .line 43
    const-string v1, "UNKNOWN"

    .line 44
    .line 45
    const/4 v2, 0x4

    .line 46
    invoke-direct {v0, v1, v2}, Lde/c;-><init>(Ljava/lang/String;I)V

    .line 47
    .line 48
    .line 49
    sput-object v0, Lde/c;->f:Lde/c;

    .line 50
    .line 51
    invoke-static {}, Lde/c;->a()[Lde/c;

    .line 52
    .line 53
    .line 54
    move-result-object v0

    .line 55
    sput-object v0, Lde/c;->g:[Lde/c;

    .line 56
    .line 57
    invoke-static {v0}, Ljd/b;->a([Ljava/lang/Enum;)Ljd/a;

    .line 58
    .line 59
    .line 60
    move-result-object v0

    .line 61
    sput-object v0, Lde/c;->h:Ljd/a;

    .line 62
    .line 63
    new-instance v0, Lde/c$a;

    .line 64
    .line 65
    const/4 v1, 0x0

    .line 66
    invoke-direct {v0, v1}, Lde/c$a;-><init>(Lkotlin/jvm/internal/k;)V

    .line 67
    .line 68
    .line 69
    sput-object v0, Lde/c;->a:Lde/c$a;

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

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 2
    .line 3
    .line 4
    return-void
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
.end method

.method public static final synthetic a()[Lde/c;
    .locals 5

    .line 1
    sget-object v0, Lde/c;->b:Lde/c;

    .line 2
    .line 3
    sget-object v1, Lde/c;->c:Lde/c;

    .line 4
    .line 5
    sget-object v2, Lde/c;->d:Lde/c;

    .line 6
    .line 7
    sget-object v3, Lde/c;->e:Lde/c;

    .line 8
    .line 9
    sget-object v4, Lde/c;->f:Lde/c;

    .line 10
    .line 11
    filled-new-array {v0, v1, v2, v3, v4}, [Lde/c;

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

.method public static valueOf(Ljava/lang/String;)Lde/c;
    .locals 1

    .line 1
    const-class v0, Lde/c;

    .line 2
    .line 3
    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    .line 4
    .line 5
    .line 6
    move-result-object p0

    .line 7
    check-cast p0, Lde/c;

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

.method public static values()[Lde/c;
    .locals 1

    .line 1
    sget-object v0, Lde/c;->g:[Lde/c;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, [Lde/c;

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
