.class public final Lw9/d$b;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lw9/d;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "b"
.end annotation


# instance fields
.field public a:Lx9/a;

.field public b:Lx9/g;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lw9/d$a;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lw9/d$b;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lx9/a;)Lw9/d$b;
    .locals 0

    .line 1
    invoke-static {p1}, Lt9/d;->b(Ljava/lang/Object;)Ljava/lang/Object;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    check-cast p1, Lx9/a;

    .line 6
    .line 7
    iput-object p1, p0, Lw9/d$b;->a:Lx9/a;

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

.method public b()Lw9/f;
    .locals 4

    .line 1
    iget-object v0, p0, Lw9/d$b;->a:Lx9/a;

    .line 2
    .line 3
    const-class v1, Lx9/a;

    .line 4
    .line 5
    invoke-static {v0, v1}, Lt9/d;->a(Ljava/lang/Object;Ljava/lang/Class;)V

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Lw9/d$b;->b:Lx9/g;

    .line 9
    .line 10
    if-nez v0, :cond_0

    .line 11
    .line 12
    new-instance v0, Lx9/g;

    .line 13
    .line 14
    invoke-direct {v0}, Lx9/g;-><init>()V

    .line 15
    .line 16
    .line 17
    iput-object v0, p0, Lw9/d$b;->b:Lx9/g;

    .line 18
    .line 19
    :cond_0
    new-instance v0, Lw9/d$c;

    .line 20
    .line 21
    iget-object v1, p0, Lw9/d$b;->a:Lx9/a;

    .line 22
    .line 23
    iget-object v2, p0, Lw9/d$b;->b:Lx9/g;

    .line 24
    .line 25
    const/4 v3, 0x0

    .line 26
    invoke-direct {v0, v1, v2, v3}, Lw9/d$c;-><init>(Lx9/a;Lx9/g;Lw9/d$a;)V

    .line 27
    .line 28
    .line 29
    return-object v0
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
