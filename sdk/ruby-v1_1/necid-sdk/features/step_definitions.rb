Before("@necid") do
  @service = NECID::Resource.new
  @client = @service.client
end

After("@necid") do
  # shared cleanup logic
end
