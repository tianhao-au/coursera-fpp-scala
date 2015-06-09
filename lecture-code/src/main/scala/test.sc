object test {
  def error(msg: String) = throw new Error(msg)
  error("ops")
}