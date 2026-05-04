.class public final enum Lq9/j;
.super Ljava/lang/Enum;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lcom/google/protobuf/c0$a;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lq9/j$b;
    }
.end annotation


# static fields
.field public static final enum b:Lq9/j;

.field public static final enum c:Lq9/j;

.field public static final enum d:Lq9/j;

.field public static final e:Lcom/google/protobuf/c0$b;

.field public static final synthetic f:[Lq9/j;


# instance fields
.field public final a:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 1
    new-instance v0, Lq9/j;

    .line 2
    .line 3
    const-string v1, "UNKNOWN_EVENT_TYPE"

    .line 4
    .line 5
    const/4 v2, 0x0

    .line 6
    invoke-direct {v0, v1, v2, v2}, Lq9/j;-><init>(Ljava/lang/String;II)V

    .line 7
    .line 8
    .line 9
    sput-object v0, Lq9/j;->b:Lq9/j;

    .line 10
    .line 11
    new-instance v0, Lq9/j;

    .line 12
    .line 13
    const-string v1, "IMPRESSION_EVENT_TYPE"

    .line 14
    .line 15
    const/4 v2, 0x1

    .line 16
    invoke-direct {v0, v1, v2, v2}, Lq9/j;-><init>(Ljava/lang/String;II)V

    .line 17
    .line 18
    .line 19
    sput-object v0, Lq9/j;->c:Lq9/j;

    .line 20
    .line 21
    new-instance v0, Lq9/j;

    .line 22
    .line 23
    const-string v1, "CLICK_EVENT_TYPE"

    .line 24
    .line 25
    const/4 v2, 0x2

    .line 26
    invoke-direct {v0, v1, v2, v2}, Lq9/j;-><init>(Ljava/lang/String;II)V

    .line 27
    .line 28
    .line 29
    sput-object v0, Lq9/j;->d:Lq9/j;

    .line 30
    .line 31
    invoke-static {}, Lq9/j;->a()[Lq9/j;

    .line 32
    .line 33
    .line 34
    move-result-object v0

    .line 35
    sput-object v0, Lq9/j;->f:[Lq9/j;

    .line 36
    .line 37
    new-instance v0, Lq9/j$a;

    .line 38
    .line 39
    invoke-direct {v0}, Lq9/j$a;-><init>()V

    .line 40
    .line 41
    .line 42
    sput-object v0, Lq9/j;->e:Lcom/google/protobuf/c0$b;

    .line 43
    .line 44
    return-void
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
.end method

.method public constructor <init>(Ljava/lang/String;II)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 2
    .line 3
    .line 4
    iput p3, p0, Lq9/j;->a:I

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

.method public static synthetic a()[Lq9/j;
    .locals 3

    .line 1
    sget-object v0, Lq9/j;->b:Lq9/j;

    .line 2
    .line 3
    sget-object v1, Lq9/j;->c:Lq9/j;

    .line 4
    .line 5
    sget-object v2, Lq9/j;->d:Lq9/j;

    .line 6
    .line 7
    filled-new-array {v0, v1, v2}, [Lq9/j;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    return-object v0
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public static b(I)Lq9/j;
    .locals 1

    .line 1
    if-eqz p0, :cond_2

    .line 2
    .line 3
    const/4 v0, 0x1

    .line 4
    if-eq p0, v0, :cond_1

    .line 5
    .line 6
    const/4 v0, 0x2

    .line 7
    if-eq p0, v0, :cond_0

    .line 8
    .line 9
    const/4 p0, 0x0

    .line 10
    return-object p0

    .line 11
    :cond_0
    sget-object p0, Lq9/j;->d:Lq9/j;

    .line 12
    .line 13
    return-object p0

    .line 14
    :cond_1
    sget-object p0, Lq9/j;->c:Lq9/j;

    .line 15
    .line 16
    return-object p0

    .line 17
    :cond_2
    sget-object p0, Lq9/j;->b:Lq9/j;

    .line 18
    .line 19
    return-object p0
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public static c()Lcom/google/protobuf/c0$c;
    .locals 1

    .line 1
    sget-object v0, Lq9/j$b;->a:Lcom/google/protobuf/c0$c;

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
.end method

.method public static valueOf(Ljava/lang/String;)Lq9/j;
    .locals 1

    .line 1
    const-class v0, Lq9/j;

    .line 2
    .line 3
    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    .line 4
    .line 5
    .line 6
    move-result-object p0

    .line 7
    check-cast p0, Lq9/j;

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

.method public static values()[Lq9/j;
    .locals 1

    .line 1
    sget-object v0, Lq9/j;->f:[Lq9/j;

    .line 2
    .line 3
    invoke-virtual {v0}, [Lq9/j;->clone()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, [Lq9/j;

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


# virtual methods
.method public final d()I
    .locals 1

    .line 1
    iget v0, p0, Lq9/j;->a:I

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
.end method
