.class public abstract enum Lyf/z$a;
.super Ljava/lang/Enum;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lyf/z;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "a"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lyf/z$a$a;,
        Lyf/z$a$b;,
        Lyf/z$a$c;,
        Lyf/z$a$d;
    }
.end annotation


# static fields
.field public static final enum a:Lyf/z$a;

.field public static final enum b:Lyf/z$a;

.field public static final enum c:Lyf/z$a;

.field public static final enum d:Lyf/z$a;

.field public static final synthetic e:[Lyf/z$a;

.field public static final synthetic f:Ljd/a;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 1
    new-instance v0, Lyf/z$a$c;

    .line 2
    .line 3
    const-string v1, "START"

    .line 4
    .line 5
    const/4 v2, 0x0

    .line 6
    invoke-direct {v0, v1, v2}, Lyf/z$a$c;-><init>(Ljava/lang/String;I)V

    .line 7
    .line 8
    .line 9
    sput-object v0, Lyf/z$a;->a:Lyf/z$a;

    .line 10
    .line 11
    new-instance v0, Lyf/z$a$a;

    .line 12
    .line 13
    const-string v1, "ACCEPT_NULL"

    .line 14
    .line 15
    const/4 v2, 0x1

    .line 16
    invoke-direct {v0, v1, v2}, Lyf/z$a$a;-><init>(Ljava/lang/String;I)V

    .line 17
    .line 18
    .line 19
    sput-object v0, Lyf/z$a;->b:Lyf/z$a;

    .line 20
    .line 21
    new-instance v0, Lyf/z$a$d;

    .line 22
    .line 23
    const-string v1, "UNKNOWN"

    .line 24
    .line 25
    const/4 v2, 0x2

    .line 26
    invoke-direct {v0, v1, v2}, Lyf/z$a$d;-><init>(Ljava/lang/String;I)V

    .line 27
    .line 28
    .line 29
    sput-object v0, Lyf/z$a;->c:Lyf/z$a;

    .line 30
    .line 31
    new-instance v0, Lyf/z$a$b;

    .line 32
    .line 33
    const-string v1, "NOT_NULL"

    .line 34
    .line 35
    const/4 v2, 0x3

    .line 36
    invoke-direct {v0, v1, v2}, Lyf/z$a$b;-><init>(Ljava/lang/String;I)V

    .line 37
    .line 38
    .line 39
    sput-object v0, Lyf/z$a;->d:Lyf/z$a;

    .line 40
    .line 41
    invoke-static {}, Lyf/z$a;->a()[Lyf/z$a;

    .line 42
    .line 43
    .line 44
    move-result-object v0

    .line 45
    sput-object v0, Lyf/z$a;->e:[Lyf/z$a;

    .line 46
    .line 47
    invoke-static {v0}, Ljd/b;->a([Ljava/lang/Enum;)Ljd/a;

    .line 48
    .line 49
    .line 50
    move-result-object v0

    .line 51
    sput-object v0, Lyf/z$a;->f:Ljd/a;

    .line 52
    .line 53
    return-void
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
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .line 2
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public synthetic constructor <init>(Ljava/lang/String;ILkotlin/jvm/internal/k;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lyf/z$a;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static final synthetic a()[Lyf/z$a;
    .locals 4

    .line 1
    sget-object v0, Lyf/z$a;->a:Lyf/z$a;

    .line 2
    .line 3
    sget-object v1, Lyf/z$a;->b:Lyf/z$a;

    .line 4
    .line 5
    sget-object v2, Lyf/z$a;->c:Lyf/z$a;

    .line 6
    .line 7
    sget-object v3, Lyf/z$a;->d:Lyf/z$a;

    .line 8
    .line 9
    filled-new-array {v0, v1, v2, v3}, [Lyf/z$a;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    return-object v0
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public static valueOf(Ljava/lang/String;)Lyf/z$a;
    .locals 1

    .line 1
    const-class v0, Lyf/z$a;

    .line 2
    .line 3
    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    .line 4
    .line 5
    .line 6
    move-result-object p0

    .line 7
    check-cast p0, Lyf/z$a;

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

.method public static values()[Lyf/z$a;
    .locals 1

    .line 1
    sget-object v0, Lyf/z$a;->e:[Lyf/z$a;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, [Lyf/z$a;

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
.method public abstract b(Lxf/l2;)Lyf/z$a;
.end method

.method public final c(Lxf/l2;)Lyf/z$a;
    .locals 1

    .line 1
    const-string v0, "<this>"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    invoke-virtual {p1}, Lxf/r0;->O0()Z

    .line 7
    .line 8
    .line 9
    move-result v0

    .line 10
    if-eqz v0, :cond_0

    .line 11
    .line 12
    sget-object p1, Lyf/z$a;->b:Lyf/z$a;

    .line 13
    .line 14
    return-object p1

    .line 15
    :cond_0
    instance-of v0, p1, Lxf/y;

    .line 16
    .line 17
    if-eqz v0, :cond_1

    .line 18
    .line 19
    move-object v0, p1

    .line 20
    check-cast v0, Lxf/y;

    .line 21
    .line 22
    invoke-virtual {v0}, Lxf/y;->Z0()Lxf/c1;

    .line 23
    .line 24
    .line 25
    :cond_1
    sget-object v0, Lyf/r;->a:Lyf/r;

    .line 26
    .line 27
    invoke-virtual {v0, p1}, Lyf/r;->a(Lxf/l2;)Z

    .line 28
    .line 29
    .line 30
    move-result p1

    .line 31
    if-eqz p1, :cond_2

    .line 32
    .line 33
    sget-object p1, Lyf/z$a;->d:Lyf/z$a;

    .line 34
    .line 35
    return-object p1

    .line 36
    :cond_2
    sget-object p1, Lyf/z$a;->c:Lyf/z$a;

    .line 37
    .line 38
    return-object p1
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
.end method
