.class public final Lw2/v$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lw2/v;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# static fields
.field public static final synthetic a:Lw2/v$a;

.field public static b:Lpd/k;

.field public static final c:Lw2/w;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 1
    new-instance v0, Lw2/v$a;

    .line 2
    .line 3
    invoke-direct {v0}, Lw2/v$a;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Lw2/v$a;->a:Lw2/v$a;

    .line 7
    .line 8
    new-instance v0, Lw2/u;

    .line 9
    .line 10
    invoke-direct {v0}, Lw2/u;-><init>()V

    .line 11
    .line 12
    .line 13
    sput-object v0, Lw2/v$a;->b:Lpd/k;

    .line 14
    .line 15
    new-instance v0, Lw2/w;

    .line 16
    .line 17
    const/4 v1, 0x0

    .line 18
    const/4 v2, 0x1

    .line 19
    invoke-direct {v0, v1, v2, v1}, Lw2/w;-><init>(La3/l;ILkotlin/jvm/internal/k;)V

    .line 20
    .line 21
    .line 22
    sput-object v0, Lw2/v$a;->c:Lw2/w;

    .line 23
    .line 24
    return-void
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
.end method

.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

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
.end method

.method public static synthetic a(Lw2/v;)Lw2/v;
    .locals 0

    .line 1
    invoke-static {p0}, Lw2/v$a;->b(Lw2/v;)Lw2/v;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    return-object p0
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
.end method

.method public static final b(Lw2/v;)Lw2/v;
    .locals 1

    .line 1
    const-string v0, "it"

    .line 2
    .line 3
    invoke-static {p0, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    return-object p0
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
.end method


# virtual methods
.method public final c()Lw2/v;
    .locals 2

    .line 1
    sget-object v0, Lw2/v$a;->b:Lpd/k;

    .line 2
    .line 3
    sget-object v1, Lw2/v$a;->c:Lw2/w;

    .line 4
    .line 5
    invoke-interface {v0, v1}, Lpd/k;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    check-cast v0, Lw2/v;

    .line 10
    .line 11
    return-object v0
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method
