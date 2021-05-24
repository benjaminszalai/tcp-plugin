import Foundation

@objc public class TcpPlugin: NSObject {
    @objc public func echo(_ value: String) -> String {
        return value
    }
}
