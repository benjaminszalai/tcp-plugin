export interface TcpPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
