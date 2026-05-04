.class public final Lp6/p;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lp6/p$b;
    }
.end annotation


# instance fields
.field public final a:Lp6/c;

.field public final b:Z

.field public final c:Lp6/p$b;

.field public final d:I


# direct methods
.method public constructor <init>(Lp6/p$b;)V
    .locals 3

    .line 1
    invoke-static {}, Lp6/c;->c()Lp6/c;

    move-result-object v0

    const v1, 0x7fffffff

    const/4 v2, 0x0

    invoke-direct {p0, p1, v2, v0, v1}, Lp6/p;-><init>(Lp6/p$b;ZLp6/c;I)V

    return-void
.end method

.method public constructor <init>(Lp6/p$b;ZLp6/c;I)V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    iput-object p1, p0, Lp6/p;->c:Lp6/p$b;

    .line 4
    iput-boolean p2, p0, Lp6/p;->b:Z

    .line 5
    iput-object p3, p0, Lp6/p;->a:Lp6/c;

    .line 6
    iput p4, p0, Lp6/p;->d:I

    return-void
.end method

.method public static a(C)Lp6/p;
    .locals 0

    .line 1
    invoke-static {p0}, Lp6/c;->b(C)Lp6/c;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    invoke-static {p0}, Lp6/p;->b(Lp6/c;)Lp6/p;

    .line 6
    .line 7
    .line 8
    move-result-object p0

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

.method public static b(Lp6/c;)Lp6/p;
    .locals 2

    .line 1
    invoke-static {p0}, Lp6/n;->n(Ljava/lang/Object;)Ljava/lang/Object;

    .line 2
    .line 3
    .line 4
    new-instance v0, Lp6/p;

    .line 5
    .line 6
    new-instance v1, Lp6/p$a;

    .line 7
    .line 8
    invoke-direct {v1, p0}, Lp6/p$a;-><init>(Lp6/c;)V

    .line 9
    .line 10
    .line 11
    invoke-direct {v0, v1}, Lp6/p;-><init>(Lp6/p$b;)V

    .line 12
    .line 13
    .line 14
    return-object v0
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
.method public c()Lp6/p;
    .locals 1

    .line 1
    invoke-static {}, Lp6/c;->e()Lp6/c;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {p0, v0}, Lp6/p;->d(Lp6/c;)Lp6/p;

    .line 6
    .line 7
    .line 8
    move-result-object v0

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

.method public d(Lp6/c;)Lp6/p;
    .locals 4

    .line 1
    invoke-static {p1}, Lp6/n;->n(Ljava/lang/Object;)Ljava/lang/Object;

    .line 2
    .line 3
    .line 4
    new-instance v0, Lp6/p;

    .line 5
    .line 6
    iget-object v1, p0, Lp6/p;->c:Lp6/p$b;

    .line 7
    .line 8
    iget-boolean v2, p0, Lp6/p;->b:Z

    .line 9
    .line 10
    iget v3, p0, Lp6/p;->d:I

    .line 11
    .line 12
    invoke-direct {v0, v1, v2, p1, v3}, Lp6/p;-><init>(Lp6/p$b;ZLp6/c;I)V

    .line 13
    .line 14
    .line 15
    return-object v0
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
