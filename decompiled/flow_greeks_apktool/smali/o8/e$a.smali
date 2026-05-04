.class public final enum Lo8/e$a;
.super Ljava/lang/Enum;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lo8/e;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "a"
.end annotation


# static fields
.field public static final enum a:Lo8/e$a;

.field public static final enum b:Lo8/e$a;

.field public static final enum c:Lo8/e$a;

.field public static final enum d:Lo8/e$a;

.field public static final enum e:Lo8/e$a;

.field public static final synthetic f:[Lo8/e$a;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 1
    new-instance v0, Lo8/e$a;

    .line 2
    .line 3
    const-string v1, "CHILD_REMOVED"

    .line 4
    .line 5
    const/4 v2, 0x0

    .line 6
    invoke-direct {v0, v1, v2}, Lo8/e$a;-><init>(Ljava/lang/String;I)V

    .line 7
    .line 8
    .line 9
    sput-object v0, Lo8/e$a;->a:Lo8/e$a;

    .line 10
    .line 11
    new-instance v0, Lo8/e$a;

    .line 12
    .line 13
    const-string v1, "CHILD_ADDED"

    .line 14
    .line 15
    const/4 v2, 0x1

    .line 16
    invoke-direct {v0, v1, v2}, Lo8/e$a;-><init>(Ljava/lang/String;I)V

    .line 17
    .line 18
    .line 19
    sput-object v0, Lo8/e$a;->b:Lo8/e$a;

    .line 20
    .line 21
    new-instance v0, Lo8/e$a;

    .line 22
    .line 23
    const-string v1, "CHILD_MOVED"

    .line 24
    .line 25
    const/4 v2, 0x2

    .line 26
    invoke-direct {v0, v1, v2}, Lo8/e$a;-><init>(Ljava/lang/String;I)V

    .line 27
    .line 28
    .line 29
    sput-object v0, Lo8/e$a;->c:Lo8/e$a;

    .line 30
    .line 31
    new-instance v0, Lo8/e$a;

    .line 32
    .line 33
    const-string v1, "CHILD_CHANGED"

    .line 34
    .line 35
    const/4 v2, 0x3

    .line 36
    invoke-direct {v0, v1, v2}, Lo8/e$a;-><init>(Ljava/lang/String;I)V

    .line 37
    .line 38
    .line 39
    sput-object v0, Lo8/e$a;->d:Lo8/e$a;

    .line 40
    .line 41
    new-instance v0, Lo8/e$a;

    .line 42
    .line 43
    const-string v1, "VALUE"

    .line 44
    .line 45
    const/4 v2, 0x4

    .line 46
    invoke-direct {v0, v1, v2}, Lo8/e$a;-><init>(Ljava/lang/String;I)V

    .line 47
    .line 48
    .line 49
    sput-object v0, Lo8/e$a;->e:Lo8/e$a;

    .line 50
    .line 51
    invoke-static {}, Lo8/e$a;->a()[Lo8/e$a;

    .line 52
    .line 53
    .line 54
    move-result-object v0

    .line 55
    sput-object v0, Lo8/e$a;->f:[Lo8/e$a;

    .line 56
    .line 57
    return-void
    .line 58
    .line 59
    .line 60
    .line 61
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
.end method

.method public static synthetic a()[Lo8/e$a;
    .locals 5

    .line 1
    sget-object v0, Lo8/e$a;->a:Lo8/e$a;

    .line 2
    .line 3
    sget-object v1, Lo8/e$a;->b:Lo8/e$a;

    .line 4
    .line 5
    sget-object v2, Lo8/e$a;->c:Lo8/e$a;

    .line 6
    .line 7
    sget-object v3, Lo8/e$a;->d:Lo8/e$a;

    .line 8
    .line 9
    sget-object v4, Lo8/e$a;->e:Lo8/e$a;

    .line 10
    .line 11
    filled-new-array {v0, v1, v2, v3, v4}, [Lo8/e$a;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    return-object v0
    .line 16
.end method

.method public static valueOf(Ljava/lang/String;)Lo8/e$a;
    .locals 1

    .line 1
    const-class v0, Lo8/e$a;

    .line 2
    .line 3
    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    .line 4
    .line 5
    .line 6
    move-result-object p0

    .line 7
    check-cast p0, Lo8/e$a;

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

.method public static values()[Lo8/e$a;
    .locals 1

    .line 1
    sget-object v0, Lo8/e$a;->f:[Lo8/e$a;

    .line 2
    .line 3
    invoke-virtual {v0}, [Lo8/e$a;->clone()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, [Lo8/e$a;

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
