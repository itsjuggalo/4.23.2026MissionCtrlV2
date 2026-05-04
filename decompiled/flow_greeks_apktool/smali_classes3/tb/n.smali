.class public final Ltb/n;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Ltb/n$b;
    }
.end annotation


# static fields
.field public static final f:Ltb/n$b;


# instance fields
.field public final a:Ltb/q2;

.field public final b:Ltb/e1;

.field public final c:Ltb/e1;

.field public final d:Ltb/e1;

.field public volatile e:J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1
    new-instance v0, Ltb/n$a;

    .line 2
    .line 3
    invoke-direct {v0}, Ltb/n$a;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Ltb/n;->f:Ltb/n$b;

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

.method public constructor <init>(Ltb/q2;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    invoke-static {}, Ltb/f1;->a()Ltb/e1;

    .line 5
    .line 6
    .line 7
    move-result-object v0

    .line 8
    iput-object v0, p0, Ltb/n;->b:Ltb/e1;

    .line 9
    .line 10
    invoke-static {}, Ltb/f1;->a()Ltb/e1;

    .line 11
    .line 12
    .line 13
    move-result-object v0

    .line 14
    iput-object v0, p0, Ltb/n;->c:Ltb/e1;

    .line 15
    .line 16
    invoke-static {}, Ltb/f1;->a()Ltb/e1;

    .line 17
    .line 18
    .line 19
    move-result-object v0

    .line 20
    iput-object v0, p0, Ltb/n;->d:Ltb/e1;

    .line 21
    .line 22
    iput-object p1, p0, Ltb/n;->a:Ltb/q2;

    .line 23
    .line 24
    return-void
    .line 25
    .line 26
.end method


# virtual methods
.method public a(Z)V
    .locals 2

    .line 1
    const-wide/16 v0, 0x1

    .line 2
    .line 3
    if-eqz p1, :cond_0

    .line 4
    .line 5
    iget-object p1, p0, Ltb/n;->c:Ltb/e1;

    .line 6
    .line 7
    invoke-interface {p1, v0, v1}, Ltb/e1;->add(J)V

    .line 8
    .line 9
    .line 10
    return-void

    .line 11
    :cond_0
    iget-object p1, p0, Ltb/n;->d:Ltb/e1;

    .line 12
    .line 13
    invoke-interface {p1, v0, v1}, Ltb/e1;->add(J)V

    .line 14
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

.method public b()V
    .locals 3

    .line 1
    iget-object v0, p0, Ltb/n;->b:Ltb/e1;

    .line 2
    .line 3
    const-wide/16 v1, 0x1

    .line 4
    .line 5
    invoke-interface {v0, v1, v2}, Ltb/e1;->add(J)V

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Ltb/n;->a:Ltb/q2;

    .line 9
    .line 10
    invoke-interface {v0}, Ltb/q2;->a()J

    .line 11
    .line 12
    .line 13
    move-result-wide v0

    .line 14
    iput-wide v0, p0, Ltb/n;->e:J

    .line 15
    .line 16
    return-void
    .line 17
    .line 18
    .line 19
.end method
