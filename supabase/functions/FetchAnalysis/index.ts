
import { createClient } from 'npm:@supabase/supabase-js'

const SUPABASE_URL = "https://nfkdhivibzefoupcpiem.supabase.co"
const SUPABASE_ANON_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im5ma2RoaXZpYnplZm91cGNwaWVtIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDQwMzQ1NDksImV4cCI6MjA1OTYxMDU0OX0.8STgBhkINYbhRS2k-vbIoC3ugVG33lvT-xiDRBA5tRs"


const supabase = createClient(SUPABASE_URL, SUPABASE_ANON_KEY);

Deno.serve(async (req) => {
  const url = new URL(req.url);
  const page = parseInt(url.searchParams.get("page") || "1");
  const limit = parseInt(url.searchParams.get("limit") || "10");
  const from = (page - 1) * limit;
  const to = from + limit - 1;

  // calling the supabase grouped view with pagination
  const { data, error, count } = await supabase
    .from("user_activity_summary")
    .select("*", { count: "exact" })
    .range(from, to);

  if (error) {
    return new Response(JSON.stringify({ error: error.message }), {status: 500});
  }

  const pagination = {
    page,
    limit,
    total: count,
    totalPages: Math.ceil((count || 0) / limit),
  }

  return new Response( JSON.stringify({ data, pagination }), { status: 200});
});
