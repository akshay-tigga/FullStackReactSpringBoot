export const LOCALHOST_URL = 'http://localhost:8080/api'

export function getAttachmentUrl(id) {
    return `${LOCALHOST_URL}/isps/${id}/download`
}