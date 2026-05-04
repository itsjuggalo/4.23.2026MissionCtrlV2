.class public final Ltb/t2;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Ltb/t2$b;,
        Ltb/t2$c;
    }
.end annotation


# static fields
.field public static final l:Ltb/t2$b;


# instance fields
.field public final a:Ltb/q2;

.field public b:J

.field public c:J

.field public d:J

.field public e:J

.field public f:J

.field public g:Ltb/t2$c;

.field public h:J

.field public i:J

.field public final j:Ltb/e1;

.field public volatile k:J


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Ltb/t2$b;

    .line 2
    .line 3
    sget-object v1, Ltb/q2;->a:Ltb/q2;

    .line 4
    .line 5
    invoke-direct {v0, v1}, Ltb/t2$b;-><init>(Ltb/q2;)V

    .line 6
    .line 7
    .line 8
    sput-object v0, Ltb/t2;->l:Ltb/t2$b;

    .line 9
    .line 10
    return-void
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

.method public constructor <init>(Ltb/q2;)V
    .locals 1

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    invoke-static {}, Ltb/f1;->a()Ltb/e1;

    move-result-object v0

    iput-object v0, p0, Ltb/t2;->j:Ltb/e1;

    .line 4
    iput-object p1, p0, Ltb/t2;->a:Ltb/q2;

    return-void
.end method

.method public synthetic constructor <init>(Ltb/q2;Ltb/t2$a;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Ltb/t2;-><init>(Ltb/q2;)V

    return-void
.end method

.method public static a()Ltb/t2$b;
    .locals 1

    .line 1
    sget-object v0, Ltb/t2;->l:Ltb/t2$b;

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


# virtual methods
.method public b()V
    .locals 4

    .line 1
    iget-wide v0, p0, Ltb/t2;->f:J

    .line 2
    .line 3
    const-wide/16 v2, 0x1

    .line 4
    .line 5
    add-long/2addr v0, v2

    .line 6
    iput-wide v0, p0, Ltb/t2;->f:J

    .line 7
    .line 8
    return-void
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

.method public c()V
    .locals 4

    .line 1
    iget-wide v0, p0, Ltb/t2;->b:J

    .line 2
    .line 3
    const-wide/16 v2, 0x1

    .line 4
    .line 5
    add-long/2addr v0, v2

    .line 6
    iput-wide v0, p0, Ltb/t2;->b:J

    .line 7
    .line 8
    iget-object v0, p0, Ltb/t2;->a:Ltb/q2;

    .line 9
    .line 10
    invoke-interface {v0}, Ltb/q2;->a()J

    .line 11
    .line 12
    .line 13
    move-result-wide v0

    .line 14
    iput-wide v0, p0, Ltb/t2;->c:J

    .line 15
    .line 16
    return-void
    .line 17
    .line 18
    .line 19
.end method

.method public d()V
    .locals 3

    .line 1
    iget-object v0, p0, Ltb/t2;->j:Ltb/e1;

    .line 2
    .line 3
    const-wide/16 v1, 0x1

    .line 4
    .line 5
    invoke-interface {v0, v1, v2}, Ltb/e1;->add(J)V

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Ltb/t2;->a:Ltb/q2;

    .line 9
    .line 10
    invoke-interface {v0}, Ltb/q2;->a()J

    .line 11
    .line 12
    .line 13
    move-result-wide v0

    .line 14
    iput-wide v0, p0, Ltb/t2;->k:J

    .line 15
    .line 16
    return-void
    .line 17
    .line 18
    .line 19
.end method

.method public e(I)V
    .locals 4

    .line 1
    if-nez p1, :cond_0

    .line 2
    .line 3
    return-void

    .line 4
    :cond_0
    iget-wide v0, p0, Ltb/t2;->h:J

    .line 5
    .line 6
    int-to-long v2, p1

    .line 7
    add-long/2addr v0, v2

    .line 8
    iput-wide v0, p0, Ltb/t2;->h:J

    .line 9
    .line 10
    iget-object p1, p0, Ltb/t2;->a:Ltb/q2;

    .line 11
    .line 12
    invoke-interface {p1}, Ltb/q2;->a()J

    .line 13
    .line 14
    .line 15
    move-result-wide v0

    .line 16
    iput-wide v0, p0, Ltb/t2;->i:J

    .line 17
    .line 18
    return-void
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public f(Z)V
    .locals 4

    .line 1
    const-wide/16 v0, 0x1

    .line 2
    .line 3
    if-eqz p1, :cond_0

    .line 4
    .line 5
    iget-wide v2, p0, Ltb/t2;->d:J

    .line 6
    .line 7
    add-long/2addr v2, v0

    .line 8
    iput-wide v2, p0, Ltb/t2;->d:J

    .line 9
    .line 10
    return-void

    .line 11
    :cond_0
    iget-wide v2, p0, Ltb/t2;->e:J

    .line 12
    .line 13
    add-long/2addr v2, v0

    .line 14
    iput-wide v2, p0, Ltb/t2;->e:J

    .line 15
    .line 16
    return-void
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

.method public g(Ltb/t2$c;)V
    .locals 0

    .line 1
    invoke-static {p1}, Lp6/n;->n(Ljava/lang/Object;)Ljava/lang/Object;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    check-cast p1, Ltb/t2$c;

    .line 6
    .line 7
    iput-object p1, p0, Ltb/t2;->g:Ltb/t2$c;

    .line 8
    .line 9
    return-void
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
