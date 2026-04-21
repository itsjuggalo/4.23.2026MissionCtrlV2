import { redirect } from 'next/navigation';

export default async function Home({
  searchParams,
}: {
  searchParams: Promise<{ [key: string]: string | string[] | undefined }>;
}) {
  const params = await searchParams;
  // If the URL has any query params (e.g. ?page=usage), forward to dashboard with them preserved
  const keys = Object.keys(params);
  if (keys.length > 0) {
    const qs = new URLSearchParams();
    for (const k of keys) {
      const v = params[k];
      if (typeof v === 'string') qs.set(k, v);
      else if (Array.isArray(v)) v.forEach((vv) => qs.append(k, vv));
    }
    redirect(`/dashboard?${qs.toString()}`);
  }
  // Bare root → landing page (unchanged behavior)
  redirect('/landing');
}
