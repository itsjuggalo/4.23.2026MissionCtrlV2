.class public Lh9/d;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lh9/d$a;,
        Lh9/d$b;
    }
.end annotation


# instance fields
.field public final a:Lh9/g;

.field public final b:Lh9/d$a;

.field public final c:Lh9/d$b;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Lh9/g;

    .line 5
    .line 6
    invoke-direct {v0}, Lh9/g;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Lh9/d;->a:Lh9/g;

    .line 10
    .line 11
    new-instance v0, Lh9/d$a;

    .line 12
    .line 13
    invoke-direct {v0, p0}, Lh9/d$a;-><init>(Lh9/d;)V

    .line 14
    .line 15
    .line 16
    iput-object v0, p0, Lh9/d;->b:Lh9/d$a;

    .line 17
    .line 18
    new-instance v0, Lh9/d$b;

    .line 19
    .line 20
    invoke-direct {v0, p0}, Lh9/d$b;-><init>(Lh9/d;)V

    .line 21
    .line 22
    .line 23
    iput-object v0, p0, Lh9/d;->c:Lh9/d$b;

    .line 24
    .line 25
    return-void
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

.method public static synthetic a(Lh9/d;)Lh9/g;
    .locals 0

    .line 1
    iget-object p0, p0, Lh9/d;->a:Lh9/g;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method


# virtual methods
.method public b(Lj9/p$c$a;)Lh9/b;
    .locals 1

    .line 1
    sget-object v0, Lj9/p$c$a;->b:Lj9/p$c$a;

    .line 2
    .line 3
    invoke-virtual {p1, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    .line 4
    .line 5
    .line 6
    move-result p1

    .line 7
    if-eqz p1, :cond_0

    .line 8
    .line 9
    iget-object p1, p0, Lh9/d;->c:Lh9/d$b;

    .line 10
    .line 11
    return-object p1

    .line 12
    :cond_0
    iget-object p1, p0, Lh9/d;->b:Lh9/d$a;

    .line 13
    .line 14
    return-object p1
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

.method public c()[B
    .locals 1

    .line 1
    iget-object v0, p0, Lh9/d;->a:Lh9/g;

    .line 2
    .line 3
    invoke-virtual {v0}, Lh9/g;->a()[B

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    return-object v0
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

.method public d([B)V
    .locals 1

    .line 1
    iget-object v0, p0, Lh9/d;->a:Lh9/g;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lh9/g;->c([B)V

    .line 4
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
.end method
